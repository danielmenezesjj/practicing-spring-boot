package com.consultorio.consultorio.Domain;


import com.consultorio.consultorio.Dto.PacientesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pacientes")
@Entity(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pacientes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paciente;
    private String nome;
    private String cpf;
    private String dt_nascimento;
    private String rg;
    private String naturalidade;
    private String celular;
    private String email;

    public Pacientes(PacientesDTO data) {
    this.nome = data.nome();
    this.cpf = data.cpf();
    this.dt_nascimento = data.dt_nascimento();
    this.rg = data.rg();
    this.naturalidade = data.naturalidade();
    this.celular = data.celular();
    this.email = data.email();

    }

    public void updatePacientes(PacientesDTO data) {
        if(data.nome() != null){
            this.nome = data.nome();
        }
        if(data.cpf() != null){
            this.cpf = data.cpf();
        }
        if(data.dt_nascimento() != null){
            this.dt_nascimento = data.dt_nascimento();
        }
        if(data.rg() != null){
            this.rg = data.rg();
        }
        if(data.naturalidade() != null){
            this.naturalidade = data.naturalidade();
        }
        if(data.celular() != null){
            this.celular = data.celular();
        }
        if(data.email() != null){
            this.email = data.email();
        }
    }
}
