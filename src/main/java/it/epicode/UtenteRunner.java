package it.epicode;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import it.epicode.utente.Utente;
import it.epicode.utente.UtenteRepository;
import it.epicode.utente.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner {

	@Autowired
	UtenteService utenteService;

	@Autowired
	UtenteRepository utenteRepo;

	@Override
	public void run(String... args) throws Exception {

		Faker faker = new Faker(new Locale("it"));
		List<Utente> utentiDb = utenteRepo.findAll();
		if (utentiDb.isEmpty()) {
			for (int i = 0; i < 20; i++) {
				String nome = faker.name().firstName();
				String cognome = faker.name().lastName();
				String email = faker.internet().emailAddress();
				Utente utente = new Utente(nome, cognome, email);
				utenteService.create(utente);
			}
		}
	}

}
