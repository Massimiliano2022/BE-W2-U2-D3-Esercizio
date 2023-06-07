package it.epicode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.postazione.Postazione;
import it.epicode.postazione.PostazioneRepository;
import it.epicode.postazione.PostazioneService;
import it.epicode.postazione.TipoPostazione;

@Component
public class PostazioneRunner implements CommandLineRunner {

	@Autowired
	PostazioneService postazioneService;

	@Autowired
	PostazioneRepository postazioneRepo;

	@Override
	public void run(String... args) throws Exception {

		List<Postazione> postazioniDb = postazioneRepo.findAll();

		if (postazioniDb.isEmpty()) {

			Postazione postazione1 = new Postazione("Torino", TipoPostazione.PRIVATO, 3);
			postazioneService.create(postazione1);

			Postazione postazione2 = new Postazione("Milano", TipoPostazione.OPEN_SPACE, 15);
			postazioneService.create(postazione2);

			Postazione postazione3 = new Postazione("Bologna", TipoPostazione.SALA_RIUNIONI, 30);
			postazioneService.create(postazione3);
		}

	}

}
