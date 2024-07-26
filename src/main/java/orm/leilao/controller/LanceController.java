package orm.leilao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orm.leilao.model.Lance;
import orm.leilao.service.LanceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/lance")
public class LanceController {
    
    /*
        {DELETE [/lance/{id}]}: delete(Long)
        {GET [/lance/{id}]}: lance(Long)
        {PUT [/lance/{id}]}: atualiza(Long,Lance)
        {GET [/lance]}: lances()

    */

    @Autowired
    private LanceService lanceService;

    @GetMapping("/{id}")
    public Lance getLanceById(@PathVariable Long id) {

        return lanceService.getLanceById(id);
    }

    @PutMapping("/{id}")
    public Lance atualizaLance(@PathVariable Long id, @RequestBody Lance lance) {
       
        return lanceService.updateLance(id, lance);
    }

    @GetMapping
    public List<Lance> allLances() {
        
        return lanceService.getAllLances();
    }
    

    @DeleteMapping("/{id}")
    public void deleteLance(@PathVariable Long id){

        lanceService.deleteLance(id);

    }

}
