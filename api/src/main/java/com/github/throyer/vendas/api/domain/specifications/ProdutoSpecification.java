package com.github.throyer.vendas.api.domain.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import com.github.throyer.vendas.api.domain.models.venda.Produto;

import org.springframework.data.jpa.domain.Specification;

public class ProdutoSpecification {

    public static Specification<Produto> where(
        Optional<String> nome,
        Optional<Integer> codigo
    ) {
        return (edificio, query, builder) -> {
            
            List<Predicate> predicates = new ArrayList<>();

            if (nome.isPresent()) {
                predicates.add(builder
                    .like(edificio
                        .get("nome"), "%" + nome.get() + "%"));
            }

            if (codigo.isPresent()) {
                predicates.add(builder
                    .between(edificio.get("codigo"), codigo.get(), Integer.MAX_VALUE));
            }

            return builder.and(getPredicates(predicates));
        };
    }

    private static Predicate [] getPredicates(List<Predicate> predicates) {
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}