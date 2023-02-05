package med.voll.api.repository;

import med.voll.api.medico.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

//Não há necessidade de criar as classes Dao
//Interface JPA, passando a classe Medico e o tipo do atributo ID
public interface MedicoRepository extends JpaRepository<Medico, Long>{
   Page<Medico> findAllByStatusTrue(Pageable paginacao);

   Page<Medico> findAllByStatusFalse(Pageable paginacao);
}
