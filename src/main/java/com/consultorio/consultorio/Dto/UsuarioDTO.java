package com.consultorio.consultorio.Dto;

import com.consultorio.consultorio.Domain.TiposDeUsuario;

public record UsuarioDTO(String email, String senha, Integer tiposDeUsuario) {
}
