package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico_DTO(

        //Anotações do Bean Validations

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        //Regex expressão regular - 4 a 5 digitos
        @Pattern(regexp = "\\d{11}")
        String telefone,

        @NotBlank
        //Regex expressão regular - 4 a 5 digitos
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid //Validar os objetovs
        DadosEndereco endereco)
{

}
