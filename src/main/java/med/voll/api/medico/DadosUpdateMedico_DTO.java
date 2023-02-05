package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosUpdateMedico_DTO(

        //Anotações do Bean Validations
        @NotNull
        Long id,
        String nome,
        //Regex expressão regular - 4 a 5 digitos
        @Pattern(regexp = "\\d{11}")
        String telefone,
        //Regex expressão regular - 4 a 5 digitos
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        DadosEndereco endereco){

}
