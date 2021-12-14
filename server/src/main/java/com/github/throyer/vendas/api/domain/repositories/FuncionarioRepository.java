package com.github.throyer.vendas.api.domain.repositories;

import com.github.throyer.vendas.api.domain.models.operational.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { }