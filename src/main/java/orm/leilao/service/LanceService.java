package orm.leilao.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.leilao.model.Lance;
// import orm.leilao.model.Participante;
import orm.leilao.repository.LanceRepository;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    // @Autowired
    // private ParticipanteService participanteService;

    public Lance updateLance(Long id, Lance lance){
        
        Optional<Lance> existeLance = lanceRepository.findById(id);

        if(existeLance.isPresent()){

            Lance lanceExistente = existeLance.get();

            lanceExistente.setValor(lance.getValor());
            lanceExistente.setParticipante(lance.getParticipante());

            return lanceRepository.save(lanceExistente);
        }

        return null;
    }

    public Lance getLanceById(Long id){

        Optional<Lance> lance = lanceRepository.findById(id);

        if(lance.isPresent()){

            return lance.get();
        }

        return null;
    }
    

    public List<Lance> getAllLances(){

        List<Lance> lances = new ArrayList<>();

        // lanceRepository.findAll().forEach(lances::add);
        lanceRepository.findAll().forEach(lance -> lances.add(lance));

        return lances;

    }
    
    public boolean deleteLance(Long id){

        try {
            
            lanceRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;

        }
    }

}
