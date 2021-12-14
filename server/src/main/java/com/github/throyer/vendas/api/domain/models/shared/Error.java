package com.github.throyer.vendas.api.domain.models.shared;

import org.springframework.validation.FieldError;

public class Error {

    private String campo;
    private String mensagem;

    public Error(FieldError error) {
        this.setCampo(error.getField());
        this.setMensagem(error.getDefaultMessage());
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mesagem) {
        this.mensagem = mesagem;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
}