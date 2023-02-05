package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico_DTO;
import med.voll.api.medico.DadosUpdateMedico_DTO;
import med.voll.api.medico.ListMedicoDTO;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired //Injeção de dependencias - Instancia o MR e passa as informações
    private MedicoRepository repository;

    @Transactional //Transação ativa com o BD
    @PostMapping//Anootation, post
    //Anotação @RequesteBody, indica que a String json irá receber os valores passasos na requisição
    public void saveMed(@RequestBody @Valid DadosCadastroMedico_DTO dadosMedico) {
        //recebe um DTO como paramentro do metodo e transformar em um Medico para então mandar para método Save()
        repository.save(new Medico(dadosMedico));
    }

    /* Método sem paginação
    @GetMapping //Anotation Get
    public List<ListMedicoDTO> listAll(){ //Método para listar todos os médicos
        // Stream() é um método do Java 8, eno médoto map() será feito um mapeamento da entidade Médico
        // para os atributos selecionados, chamando o construtor do DTO ListMedicoDTO, finalizando com o método toList()
        return repository.findAll().stream().map(ListMedicoDTO::new).toList() ;
    }
    */

    /*
    //Método com Paginação - Substitui o o List por Page e acrescenta os paramentros no listAll(Pageable paginacao) e no método findAll(paginacao)
    @GetMapping //Anotation Get
    public Page<ListMedicoDTO> listByStatusTrue(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
        return repository.findAll(paginacao).map(ListMedicoDTO::new);
    }
     */

    //Método para atualizar
    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DadosUpdateMedico_DTO dadosMedico){
        var medico = repository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
    }

    //Método para inativa - Neste modelo apenas inativa o medico
    @DeleteMapping("/{id}")
    @Transactional
    //A annotation @PathVariable vincula o Id  passado no @DeleteMapping com o id criado no método delete(Long id)
    public void inativa(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desabilitar();
    }

    //Método com Paginação - Substitui o o List por Page e acrescenta os paramentros no listAll(Pageable paginacao) e no método findAll(paginacao)
    @GetMapping("/true") //Anotation Get
    public Page<ListMedicoDTO> listByStatusTrue(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
        return repository.findAllByStatusTrue(paginacao).map(ListMedicoDTO::new);
    }

    //Método com Paginação - Substitui o o List por Page e acrescenta os paramentros no listAll(Pageable paginacao) e no método findAll(paginacao)
    @GetMapping("/false") //Anotation Get
    public Page<ListMedicoDTO> listByStatusFalse(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
        return repository.findAllByStatusFalse(paginacao).map(ListMedicoDTO::new);
    }

    @GetMapping("/listAll") //Anotation Get
    public Page<ListMedicoDTO> findAll(@PageableDefault(size=10, sort = {"nome"}) Pageable paginacao){ //Método para listar todos os médicos
        return repository.findAll(paginacao).map(ListMedicoDTO::new);
    }
    /*
    //Método para delete

    @DeleteMapping("/{id}")
    @Transactional
    //A annotation @PathVariable vincula o Id  passado no @DeleteMapping com o id criado no método delete(Long id)
    public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }
     */


}