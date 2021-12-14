package com.github.throyer.vendas.api.domain.models.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Pessoa extends Auditavel {

    @JsonIgnore
    public abstract String getDocumento();
}
