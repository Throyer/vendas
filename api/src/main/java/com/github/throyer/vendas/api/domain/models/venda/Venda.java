package com.github.throyer.vendas.api.domain.models.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.github.throyer.vendas.api.domain.models.cliente.ClientePF;
import com.github.throyer.vendas.api.domain.models.cliente.ClientePJ;
import com.github.throyer.vendas.api.domain.models.operational.Funcionario;
import com.github.throyer.vendas.api.domain.models.shared.Auditavel;
import com.github.throyer.vendas.api.domain.repositories.ProdutoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Entity
public class Venda extends Auditavel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_pj_id")
    private ClientePJ clientePj;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "cliente_pf_id")
    private ClientePF clientePf;

    @NotNull
    @ManyToOne
    private Funcionario vendedor;

    @NotEmpty
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "venda")
    private List<Item> itens;

    private LocalDateTime data;

    private BigDecimal total;

    public Venda() { }

    public Venda(Venda venda, ProdutoRepository repository) {
        this.clientePf = venda.getClientePf();
        this.clientePj = venda.getClientePj();
        this.vendedor = venda.getVendedor();
        this.data = LocalDateTime.now();
        this.setItens(venda.getItens(), repository);
        this.total = calcularTotal();
    }

    private Item criarItem(Item item, Venda venda, ProdutoRepository repository) {
        var produto = repository
            .findById(item.getProduto().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new Item(item, produto, venda);
    }

    public ClientePJ getClientePj() {
        return clientePj;
    }

    public void setClientePj(ClientePJ clientePj) {
        this.clientePj = clientePj;
    }

    public ClientePF getClientePf() {
        return clientePf;
    }

    public void setClientePf(ClientePF clientePf) {
        this.clientePf = clientePf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setItens(List<Item> itens, ProdutoRepository repository) {
        this.itens = itens.stream()
            .map(item ->  criarItem(item, this, repository))
                .collect(Collectors.toList());
    }

    public LocalDateTime getData() {
        return data;
    }

    public BigDecimal getTotal() {
        if (Objects.isNull(total)) {
            this.total = calcularTotal();
        }
        return total;
    }

    public BigDecimal calcularTotal() {
        return itens
        .stream()
            .map(Item::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itens: " + itens.toString() + " Total: R$" + getTotal();
    }
}
