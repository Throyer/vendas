package com.github.throyer.vendas.api.services;

import java.util.List;

import com.github.throyer.vendas.api.domain.models.venda.Venda;
import com.github.throyer.vendas.api.domain.repositories.ProdutoRepository;
import com.github.throyer.vendas.api.domain.repositories.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendasRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Venda> findAll() {
        return vendasRepository.findAll();
    }

    public Page<Venda> findAll(Pageable pageable) {
        return vendasRepository.findAll(pageable);
    }
    
    public Venda persistir(Venda venda) {
        return vendasRepository.save(new Venda(venda, produtoRepository));
    }
}