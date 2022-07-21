package com.github.throyer.vendas.api.domain.repositories;

import com.github.throyer.vendas.api.domain.models.venda.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> { }