package com.github.throyer.vendas.api.domain.repositories;

import com.github.throyer.vendas.api.domain.models.cliente.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ClienteRepository
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> { }