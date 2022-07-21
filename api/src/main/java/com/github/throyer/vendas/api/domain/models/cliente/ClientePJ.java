package com.github.throyer.vendas.api.domain.models.cliente;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cliente_pj")
public class ClientePJ extends Cliente {

    private static final long serialVersionUID = 1L;

    @NotEmpty
    @Column(nullable = false, unique =  true)
    private String cnpj;
    
    private String nomeFantasia;

    @NotEmpty
    @Column(nullable = false, unique =  true)
    private String razaoSocial;

    @Override
    public String getDocumento() {
        return getCnpj();
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if ((this == object) ||
            (Objects.isNull(object)) ||
            (!Objects.equals(getClass(), object.getClass()))) {
            return true;
        }

        final ClientePJ other = (ClientePJ) object;
        return Objects.equals(this.cnpj, other.cnpj);
    }

    @Override
    public String toString() {
        return getRazaoSocial();
    }
    
}
