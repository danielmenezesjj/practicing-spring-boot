package com.consultorio.consultorio.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "medicos")
@Entity(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medicos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medico;
    private String nome;
    private String especialidade;
    private String cpf;
    private String dt_nascimento;
    private String rg;
    private String naturalidade;
    private String celular;
    private String email;
    private String endereco;


}
