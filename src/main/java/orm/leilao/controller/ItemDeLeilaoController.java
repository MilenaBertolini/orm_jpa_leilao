package orm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orm.leilao.model.ItemDeLeilao;
import orm.leilao.service.ItemDeLeilaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {

    /*
        {DELETE [/itemdeleilao/{id}]}: delete(Long)
        {GET [/itemdeleilao/{id}]}: item(Long)
        {PUT [/itemdeleilao/{id}]}: atualiza(Long,ItemDeLeilao)
        {POST [/itemdeleilao]}: novo(ItemDeLeilao)
        {GET [/itemdeleilao]}: itens()

    
    */

    @Autowired
    private ItemDeLeilaoService itemDeLeilaoService;

    @PostMapping
    public ItemDeLeilao postItemDeLeilao(@RequestBody ItemDeLeilao item) {
        
        return itemDeLeilaoService.createItemDeLeilao(item);
    }

    @PutMapping("/{id}")
    public ItemDeLeilao atualiza (@PathVariable Long id, @RequestBody ItemDeLeilao item) {
        
        return itemDeLeilaoService.updateItemDeLeilao(id, item);
        
    }

    @GetMapping("/{id}")
    public ItemDeLeilao item(@PathVariable Long id) {

        return itemDeLeilaoService.getItemLeilaoById(id);
    }
   
    @GetMapping
    public List<ItemDeLeilao> items () {
        
        return itemDeLeilaoService.getAllItensLeilao();
    }
    
    @DeleteMapping("/{id}")
    public void deleteItemLeilao(@PathVariable Long id){

        itemDeLeilaoService.deleteItemDeLeilao(id);

    }
    
    
}
