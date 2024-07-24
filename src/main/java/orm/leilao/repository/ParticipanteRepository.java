package orm.leilao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import orm.leilao.model.Participante;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Long> {

    
} 