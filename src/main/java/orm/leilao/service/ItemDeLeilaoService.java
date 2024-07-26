package orm.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.leilao.model.ItemDeLeilao;
import orm.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemDeLeilaoService {
    
    @Autowired
    private ItemDeLeilaoRepository itemDeLeilaoRepository;

    public ItemDeLeilao createItemDeLeilao(ItemDeLeilao itemDeLeilao){

        return itemDeLeilaoRepository.save(itemDeLeilao);

    }

    public ItemDeLeilao updateItemDeLeilao(Long id, ItemDeLeilao item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateItemDeLeilao'");
    }

    public ItemDeLeilao getItemLeilaoById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'busca'");
    }

    public List<ItemDeLeilao> getAllItensLeilao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllItensLeilao'");
    }
 
    public void deleteItemDeLeilao(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteItemDeLeilao'");
    }

}
