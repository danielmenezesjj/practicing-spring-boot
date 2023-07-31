package com.consultorio.consultorio.Dto;

import jakarta.validation.constraints.NotNull;

public record PacientesDTO(@NotNull String nome, @NotNull String cpf, @NotNull String dt_nascimento, @NotNull String rg, @NotNull String naturalidade
, @NotNull String celular, @NotNull String email) {
}
