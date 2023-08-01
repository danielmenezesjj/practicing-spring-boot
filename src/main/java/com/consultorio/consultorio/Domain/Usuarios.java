package com.consultorio.consultorio.Domain;

import com.consultorio.consultorio.Dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_usuario;
    private String email;
    private String senha;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TiposDeUsuario tiposDeUsuario;

    public Usuarios(UsuarioDTO data) {

        this.email = data.email();
        this.senha = data.senha();


    }
}
