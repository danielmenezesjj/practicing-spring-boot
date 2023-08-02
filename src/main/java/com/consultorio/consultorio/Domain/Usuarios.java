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
    @JoinColumn(name = "tipo_usuario_id")
    private TiposDeUsuario tiposDeUsuario;


    public Usuarios(UsuarioDTO data, TiposDeUsuario tiposDeUsuario) {
        this.email = data.email();
        this.senha = data.senha();
        this.tiposDeUsuario = tiposDeUsuario;
    }

    public void updateUser(UsuarioDTO data) {
        if(data.email() != null){
            this.email = data.email();
        }
        if(data.senha() != null){
            this.senha = data.senha();
        }
        if(data.tipo_usuario_id() != null){
            this.tiposDeUsuario = tiposDeUsuario;
        }
    }
}
