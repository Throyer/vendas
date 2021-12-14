package com.github.throyer.vendas.api.domain.specifications;

import static com.github.throyer.vendas.api.utils.PredicateUtils.toArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import com.github.throyer.vendas.api.domain.models.cliente.Cliente;
import com.github.throyer.vendas.api.domain.models.cliente.ClientePF;
import com.github.throyer.vendas.api.domain.models.cliente.ClientePJ;

import org.springframework.data.jpa.domain.Specification;

/**
 * ProdutoSpecification
 */
public class ClienteSpecification {
    public static Specification<Cliente> where(
        Optional<String> documento,
        Optional<String> rg,
        Optional<String> nome,
        Optional<Integer> codigo
    ) {
        return (cliente, query, builder) -> {
            
            List<Predicate> predicates = new ArrayList<>();

            if (documento.isPresent()) {
                var pj = builder.treat(cliente, ClientePJ.class);
                var pf = builder.treat(cliente, ClientePF.class);
                var byCnpj = builder.equal(pj.get("cnpj"), documento.get());
                var byCpf = builder.equal(pf.get("cpf"), documento.get());
                var queryOr = builder.or(byCnpj, byCpf);
                predicates.add(queryOr);
            }

            if (nome.isPresent()) {
                var pj = builder.treat(cliente, ClientePJ.class);
                var pf = builder.treat(cliente, ClientePF.class);
                var byNomeFantasia = builder.like(pj.get("nomeFantasia"), "%" + nome.get() + "%");
                var byRazaoSocial = builder.like(pj.get("razaoSocial"), "%" + nome.get() + "%");
                var byNome = builder.like(pf.get("nome"), "%" + nome.get() + "%");
                var queryOr = builder.or(byNomeFantasia, byRazaoSocial, byNome);
                predicates.add(queryOr);
            }

            if (rg.isPresent()) {
                predicates.add(builder
                    .equal(builder.treat(cliente, ClientePF.class).get("rg"), rg.get()));
            }
            
            if (codigo.isPresent()) {
                predicates.add(builder
                    .equal(cliente.get("codigo"), codigo.get()));
            }

            return builder.or(toArray(predicates));
        };
    }
}