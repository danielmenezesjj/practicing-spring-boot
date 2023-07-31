package Domain;


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
    private Integer idade;
    private String endereco;
    private String telefone;

}
