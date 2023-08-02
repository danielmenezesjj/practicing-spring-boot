package com.consultorio.consultorio.Dto;

import com.consultorio.consultorio.Domain.TiposDeUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record UsuarioDTO(String email, String senha, Integer tipo_usuario_id) {
}
