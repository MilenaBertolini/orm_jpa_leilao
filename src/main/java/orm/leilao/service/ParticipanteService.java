package orm.leilao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.leilao.model.Participante;
import orm.leilao.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
    
    @Autowired
    private ParticipanteRepository participanteRepository;

    public Participante saveParticipante(Participante participante){

        return participanteRepository.save(participante);

    }

    public Participante updateParticipante(Long id, Participante participante){

        Optional<Participante> existeParticipante = participanteRepository.findById(id);

        if(existeParticipante.isPresent()){

            Participante participanteExistente = existeParticipante.get();
            participanteExistente.setNome(participante.getNome());
            participanteExistente.setCpf(participante.getCpf());

            return participanteRepository.save(participanteExistente);
        }

        return null;
    }

    public Participante getByIdParticipante(Long id){

        Optional<Participante> existeParticipante = participanteRepository.findById(id);

        if(existeParticipante.isPresent()){

            return existeParticipante.get();

        }
        
        return null;

    }

    public List<Participante> getAllParticipantes(){
        
        List<Participante> participantes = new ArrayList<>();

        // participanteRepository.findAll().forEach(participantes::add);
        participanteRepository.findAll().forEach(participante -> participantes.add(participante));

        return participantes;
    }

    public boolean deleteParticipante(Long id){

        try {

            participanteRepository.deleteById(id);
            
            return true;

        } catch (Exception e) {

            return false;
        }
    }

}
