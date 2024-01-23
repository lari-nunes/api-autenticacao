package com.br.larissa.apiautenticacao.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigInteger;

public record ProductRequesDTO(
        @NotBlank
        String name,

        @NotNull
        Integer price
) {
}
