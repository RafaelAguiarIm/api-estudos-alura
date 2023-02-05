package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
//Anotations Lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.numero = endereco.numero();
        this.cep = endereco.cep();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarEndereco(DadosEndereco dadosEndereco) {
        if (dadosEndereco.logradouro() != null){
            this.logradouro = dadosEndereco.logradouro();
        }
        if (dadosEndereco.bairro() != null){
            this.bairro = dadosEndereco.bairro();
        }
        if (dadosEndereco.numero() != null){
            this.numero = dadosEndereco.numero();
        }
        if (dadosEndereco.cep() != null){
            this.cep = dadosEndereco.cep();
        }
        if (dadosEndereco.complemento() != null){
            this.complemento = dadosEndereco.complemento();
        }
        if (dadosEndereco.cidade() != null){
            this.cidade = dadosEndereco.cidade();
        }
        if (dadosEndereco.uf() != null){
            this.uf = dadosEndereco.uf();
        }
    }
}
