package orm.leilao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import orm.leilao.model.Lance;

@Repository
public interface LanceRepository extends CrudRepository<Lance, Long>{

    // Assinatura de método
    List<Lance> findByParticipanteId(Long id);

    // Todos os lances do participante com id = 117 e valor maior do que 100
    // List<Lance> findByParticpanteIdAndValorGreaterThan(Long id, Double valor);

    
} 