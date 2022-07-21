package com.github.throyer.vendas.api.domain.models.venda;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.throyer.vendas.api.domain.models.shared.Auditavel;

@Entity
public class Item extends Auditavel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer quantidade;
    
    @ManyToOne
    private Produto produto;
    
    @JsonIgnore
    @ManyToOne(cascade = ALL)
    private Venda venda;

    private BigDecimal total;

    public Item() { }

    public Item(Item item, Produto produto, Venda venda) {
        this.quantidade = item.getQuantidade();
        this.produto = produto;
        this.venda = venda;
        this.total = calcularTotal();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

	public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        if (Objects.isNull(produto)) {
            return new Produto();
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getTotal() {
        if (Objects.isNull(total)) {
            this.total = calcularTotal();
        }
        return total;
    }

    public BigDecimal calcularTotal() {
        if (Objects.isNull(getProduto()) || Objects.isNull(getProduto().getPreco())) {
            return BigDecimal.valueOf(0);
        } else {
            return produto.getPreco().multiply(BigDecimal.valueOf(getQuantidade()));
        }
    }

    @Override
    public String toString() {
        return "[ " + getQuantidade() + " ] \"" + getProduto().toString() + "\" Total: R$" + getTotal();
    }
}
