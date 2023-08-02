package com.consultorio.consultorio.Domain;

import com.consultorio.consultorio.Dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuarios implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
