package com.github.throyer.vendas.api.domain.models.cliente;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente_pf")
public class ClientePF extends Cliente {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    private String nome;

    private String rg;

    @NotEmpty
    @Column(nullable = false, unique =  true)
    private String cpf;       

    @Override
    public String getDocumento() {
        return getCpf();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if ((this == object) ||
            (Objects.isNull(object)) ||
            (!Objects.equals(getClass(), object.getClass()))) {
            return true;
        }

        final ClientePF other = (ClientePF) object;
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return getNome();
    }
}
