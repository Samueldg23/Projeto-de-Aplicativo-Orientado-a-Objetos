package com.unisales.util;

import java.math.BigDecimal;
import java.util.List;

import com.unisales.domain.ContaBancaria;

public final class Validador {
    private Validador() {}

    public static void notBlank(String s, String message) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException(message);
    }

    public static void nonNull(Object o, String message) {
        if (o == null) throw new IllegalArgumentException(message);
    }

    public static void positive(BigDecimal n, String message) {
        if (n == null || n.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException(message);
    }

    public static boolean duplicated(String c, List<ContaBancaria> contas) {
        return contas.stream().anyMatch(t -> c.equals(t.getNumero()));
    }
}
