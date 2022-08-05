package com.github.throyer.vendas.api.controllers;

import static org.springframework.http.ResponseEntity.ok;

import javax.validation.Valid;

import com.github.throyer.vendas.api.domain.models.venda.Venda;
import com.github.throyer.vendas.api.domain.pagination.Page;
import com.github.throyer.vendas.api.services.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendasController {

    @Autowired
    private VendaService service;

    @GetMapping
    public ResponseEntity<Page<Venda>> index(Pageable pageable) {
        return ok(Page.of(service.findAll(pageable)));
    }

    @PostMapping
    public ResponseEntity<Venda> store(@RequestBody @Valid Venda venda) {
        return ok(service.persistir(venda));
    }
}