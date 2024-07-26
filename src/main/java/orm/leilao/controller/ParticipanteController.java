package orm.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orm.leilao.model.Participante;
import orm.leilao.service.ParticipanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/participante")
public class ParticipanteController {

    /*
     * {DELETE [/participante/{id}]}: delete(Long)
        {GET [/participante/{id}]}: participante(Long)
        {PUT [/participante/{id}]}: atualiza(Long,Participante)
        {POST [/participante]}: novo(Participante)
        {GET [/participante]}: participantes()

    */

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping("/{id}")
    public Participante getParticipanteById(@PathVariable Long id) {

        return participanteService.getByIdParticipante(id);
    }

    @PutMapping("/{id}")
    public Participante atualizaParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        
        return participanteService.updateParticipante(id, participante);
    }
    
    @PostMapping
    public Participante createParticipante(@RequestBody Participante participante) {
        
        return participanteService.saveParticipante(participante);
    }

    @GetMapping
    public List<Participante> participantes() {

        return participanteService.getAllParticipantes();
    }
    
    @DeleteMapping("/{id}")
    public void deleteParticipante(@PathVariable Long id){

        participanteService.deleteParticipante(id);
    }


    
}
