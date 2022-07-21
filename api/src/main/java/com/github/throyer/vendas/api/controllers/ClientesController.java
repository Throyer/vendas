package com.github.throyer.vendas.api.controllers;

import static com.github.throyer.vendas.api.domain.specifications.ClienteSpecification.where;
import static com.github.throyer.vendas.api.utils.Assert.anyPresent;
import static com.github.throyer.vendas.api.utils.PageUtils.of;

import java.util.Optional;

import com.github.throyer.vendas.api.domain.models.cliente.Cliente;
import com.github.throyer.vendas.api.domain.pagination.Page;
import com.github.throyer.vendas.api.domain.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClientesController
 */
@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public Page<Cliente> index(
        @RequestParam Optional<String> documento,
        @RequestParam Optional<String> rg,
        @RequestParam Optional<String> nome,
        @RequestParam Optional<Integer> codigo,
        @RequestParam Optional<Integer> page,
        @RequestParam Optional<Integer> size
    ) {
        if (anyPresent(documento, rg, nome, codigo)) {            
            return Page.of(repository.findAll(where(documento, rg, nome, codigo), of(page, size)));
        }
        return Page.of(repository.findAll(of(page, size)));
    }
}