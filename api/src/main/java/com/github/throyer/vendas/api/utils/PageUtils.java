package com.github.throyer.vendas.api.utils;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

public class PageUtils {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final Integer MAX_PAGE_SIZE = 500;

    public static Pageable of(
        Optional<Integer> optionalPage,
        Optional<Integer> optionalSize
    ) {
        Integer page = optionalPage.orElse(DEFAULT_PAGE_NUMBER);
        Integer size = optionalSize.orElse(DEFAULT_PAGE_SIZE);
        if (valid(page, size)) {
            return PageRequest.of(page, size);
        }
        return PageRequest.of(DEFAULT_PAGE_NUMBER, DEFAULT_PAGE_SIZE);
    }

    public static Pageable of(
        Optional<Integer> optionalPage,
        Optional<Integer> optionalSize,
        Direction direction,
        String... properties
    ) {
        Integer page = optionalPage.orElse(DEFAULT_PAGE_NUMBER);
        Integer size = optionalSize.orElse(DEFAULT_PAGE_SIZE);
        if (valid(page, size)) {
            return PageRequest.of(page, size, direction, properties);
        }
        return PageRequest.of(
            DEFAULT_PAGE_NUMBER,
            DEFAULT_PAGE_SIZE,
            direction,
            properties
        );
    }

    /**
     * Valida se a pagina não vai
     * ultrapassar o tamanho maximo permitido.
     * @param page numero da pagina.
     * @param size quantidade de elementos por pagina.
     * @return boolean
     */
    private static Boolean valid(Integer page, Integer size) {
        return ((page >= DEFAULT_PAGE_NUMBER) && (size <= MAX_PAGE_SIZE));
    }
}