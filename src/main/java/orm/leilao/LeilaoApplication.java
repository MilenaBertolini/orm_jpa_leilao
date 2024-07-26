package orm.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import orm.leilao.model.ItemDeLeilao;
import orm.leilao.model.Lance;
import orm.leilao.model.Participante;
import orm.leilao.repository.ItemDeLeilaoRepository;
import orm.leilao.repository.LanceRepository;
import orm.leilao.repository.ParticipanteRepository;

@SpringBootApplication
public class LeilaoApplication implements CommandLineRunner{

	@Autowired
	private ItemDeLeilaoRepository itemDeLeilaoRepository;

	@Autowired
	private LanceRepository lanceRepository;

	@Autowired
	private ParticipanteRepository participanteRepository;

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ItemDeLeilao bicicleta = new ItemDeLeilao("Bicicleta", 1000.00, true);
		Participante joao = new Participante("João", "123456");
		Lance lance = new Lance(1000.0, joao);
		bicicleta.adicionarLance(lance);

		participanteRepository.save(joao);
		lanceRepository.save(lance);
		itemDeLeilaoRepository.save(bicicleta);

		System.out.println("id: " + bicicleta.getId());
		System.out.println("Participante: \n  Nome: " + joao.getNome() + "\n  Cpf: " + joao.getCpf());

	}

}
