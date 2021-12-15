package com.github.throyer.vendas.api.domain.models.cliente;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.throyer.vendas.api.domain.models.shared.Pessoa;

@JsonTypeInfo(
    visible = true,
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ClientePJ.class, name = "PJ"),
    @JsonSubTypes.Type(value = ClientePF.class, name = "PF")
})
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if ((this == object) ||
            (Objects.isNull(object)) ||
            (!Objects.equals(getClass(), object.getClass()))) {
            return true;
        }

        final Cliente other = (Cliente) object;
        return Objects.equals(this.id, other.id);
    }
}
