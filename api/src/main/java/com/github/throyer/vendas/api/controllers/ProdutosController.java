package com.github.throyer.vendas.api.controllers;

import static com.github.throyer.vendas.api.domain.specifications.ProdutoSpecification.where;
import static com.github.throyer.vendas.api.utils.PageUtils.of;

import java.util.Optional;

import com.github.throyer.vendas.api.domain.models.venda.Produto;
import com.github.throyer.vendas.api.domain.pagination.Page;
import com.github.throyer.vendas.api.domain.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public Page<Produto> index(
        @RequestParam Optional<String> nome,
        @RequestParam Optional<Integer> codigo,
        @RequestParam Optional<Integer> page,
        @RequestParam Optional<Integer> size
    ) {
        if (nome.isPresent() || codigo.isPresent()) {
            return Page.of(repository.findAll(where(nome, codigo), of(page, size)));
        }
        return Page.of(repository.findAll(of(page, size)));
    }
}