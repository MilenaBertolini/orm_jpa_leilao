package orm.leilao.service;

import java.util.ArrayList;
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

        item.setId(id);

        return itemDeLeilaoRepository.save(item);
    }

    public ItemDeLeilao getItemLeilaoById(Long id) {

        return itemDeLeilaoRepository.findById(id).get();
    }

    public List<ItemDeLeilao> getAllItensLeilao() {
        
        List<ItemDeLeilao> itensLeilao = new ArrayList<>();

        // lanceRepository.findAll().forEach(lances::add);
        itemDeLeilaoRepository.findAll().forEach(item -> itensLeilao.add(item));

        return itensLeilao;

    }
 
    public void deleteItemDeLeilao(Long id) {
        
        itemDeLeilaoRepository.deleteById(id);
    }

}
