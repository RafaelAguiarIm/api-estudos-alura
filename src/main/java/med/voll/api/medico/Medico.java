package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

//Anotations JPA
@Table(name = "medicos")
@Entity(name = "Medico")
//Anotations Lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean status;


    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    //Anotations de composição
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico_DTO dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();

        this.endereco = new Endereco(dadosMedico.endereco());
        this.especialidade = dadosMedico.especialidade();

        this.status = true;
    }

    public void atualizarInformacoes(DadosUpdateMedico_DTO dadosMedico) {
        if (dadosMedico.nome() != null){
            this.nome = dadosMedico.nome();

        }

        if (dadosMedico.telefone() != null){
            this.telefone = dadosMedico.telefone();

        }

        if (dadosMedico.endereco() != null){
            this.endereco.atualizarEndereco(dadosMedico.endereco());

        }

        if (dadosMedico.nome() != null){
            this.nome = dadosMedico.nome();

        }

    }

    public void desabilitar() {
        this.status = false;
    }
}
