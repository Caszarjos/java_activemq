package com.jose.pc2.domain;

import java.io.Serializable;

public record Aliado (
        String Apertura,
        String Categoria,
        String Codigo,
        String Negocio
) implements Serializable {
    @Override
    public String toString() {
        return "Aliado{" +
                "Apertura='" + Apertura + '\'' +
                ", Categoria='" + Categoria + '\'' +
                ", Codigo='" + Codigo + '\'' +
                ", Negocio='" + Negocio + '\'' +
                '}';
    }
}
