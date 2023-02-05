package med.voll.api.medico;

//Neste DTO eu devolvo apenas os campos que são necessários para o cliente
public record ListMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {

    //Construtor criado para ser chamado no método Stream().map() do Java 8, na classe MédicoCntroller
    public ListMedicoDTO(Medico medico){
        this( medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
