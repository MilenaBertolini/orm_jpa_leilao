package orm.leilao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import orm.leilao.model.ItemDeLeilao;

@Repository
public interface ItemDeLeilaoRepository extends CrudRepository<ItemDeLeilao, Long>{

    
} 