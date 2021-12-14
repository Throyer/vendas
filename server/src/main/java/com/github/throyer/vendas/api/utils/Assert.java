package com.github.throyer.vendas.api.utils;

import java.util.List;
import java.util.Optional;

public class Assert {
    public static Boolean anyPresent(Optional<?> ...values) {
        return List.of(values).stream().anyMatch(Optional::isPresent);
    }
}