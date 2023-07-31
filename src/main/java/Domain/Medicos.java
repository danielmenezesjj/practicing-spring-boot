package Domain;


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
    private String cpf;
    private String telefone;
    private String endereco;
    private String especialidade;

}
