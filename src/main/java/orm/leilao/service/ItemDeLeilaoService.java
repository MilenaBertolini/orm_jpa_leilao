package orm.leilao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.leilao.model.ItemDeLeilao;
import orm.leilao.model.Lance;
import orm.leilao.model.Participante;
import orm.leilao.repository.ItemDeLeilaoRepository;

@Service
public class ItemDeLeilaoService {
    
    @Autowired
    private ItemDeLeilaoRepository itemDeLeilaoRepository;

    @Autowired
    private LanceService lanceService;

    public ItemDeLeilao createItemDeLeilao(ItemDeLeilao itemDeLeilao){

        return itemDeLeilaoRepository.save(itemDeLeilao);

    }

    public ItemDeLeilao updateItemDeLeilao(Long id, ItemDeLeilao item) {

        Optional<ItemDeLeilao> existeItem = itemDeLeilaoRepository.findById(id);

        if(existeItem.isPresent()){

            ItemDeLeilao itemExistente = existeItem.get();
            itemExistente.setNome(item.getNome());
            itemExistente.setValorMinimo(item.getValorMinimo());
            itemExistente.setLeilaoAberto(item.isLeilaoAberto());
            
            return itemDeLeilaoRepository.save(itemExistente);
        }

        return null;       

    }

    public ItemDeLeilao getItemLeilaoById(Long id) {

        Optional<ItemDeLeilao> existeItem = itemDeLeilaoRepository.findById(id);

        if(existeItem.isPresent()){

            return existeItem.get();
        }

        return null;
    }

    public List<ItemDeLeilao> getAllItensLeilao() {
        
        List<ItemDeLeilao> itensLeilao = new ArrayList<>();

        itemDeLeilaoRepository.findAll().forEach(itensLeilao::add);

        return itensLeilao;

    }
 
    public boolean deleteItemDeLeilao(Long id) {

        try {
            
            itemDeLeilaoRepository.deleteById(id);

            return true;
            
        } catch (Exception e) {
            
            return false;
        }
        
    }

    public Lance lanceItemDeLeilao(Long id, Lance lance){

        ItemDeLeilao getItem = getItemLeilaoById(id);
        

        if(getItem != null && verificaLeilao(getItem)){

            if(validaValorLance(lance.getValor())){
                
                getItem.getLancesRecebidos().add(lance);
                getItem.setLanceVencedor(lance);

                return lanceService.createLance(lance);

            }

            
        }

        return null;        

    }

    public boolean verificaLeilao(ItemDeLeilao item){

        if(item.isLeilaoAberto()){
            return true;
        }

        return false;
    }

    public boolean validaValorLance(Double valor){

        List<Lance> allLances;

        allLances = lanceService.getAllLances();

        Double maiorLance = pegaMaiorLance(allLances);

        if(valor>maiorLance){

            return true;
        }

        return false;
    }

    public double pegaMaiorLance(List<Lance> allLances){

        Double maiorValor = Double.MIN_VALUE;

        for(Lance lance : allLances){
            if (lance.getValor() > maiorValor) {
                maiorValor = lance.getValor();
            }
        }

        return maiorValor;

    }

    public Participante finalizaLeilao(Long id){

        ItemDeLeilao getItem = getItemLeilaoById(id);

        getItem.setLeilaoAberto(false);

        Participante arrematante = getItem.getLanceVencedor().getParticipante();

        return arrematante;

        
    }

}
