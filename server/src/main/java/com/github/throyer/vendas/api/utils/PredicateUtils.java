package com.github.throyer.vendas.api.utils;

import java.util.List;

import javax.persistence.criteria.Predicate;

public class PredicateUtils {
    public static Predicate [] toArray(List<Predicate> predicates) {
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}