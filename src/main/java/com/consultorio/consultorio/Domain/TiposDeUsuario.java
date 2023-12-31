package com.consultorio.consultorio.Domain;

import com.consultorio.consultorio.Dto.TipoUsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipousuario")
@Entity(name = "tipousuario")
@Getter
@Setter
public class TiposDeUsuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoUsuario") // Defina o nome da coluna aqui
    private Integer id_tipousuario; // Mantenha o nome do campo como está (id_tipousuario)
    private String nome;

    public TiposDeUsuario(TipoUsuarioDTO data) {

        this.nome = data.nome();

    }

    public void updateTypeUser(TipoUsuarioDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
    }
}
