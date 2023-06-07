package it.epicode.prenotazione;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.exceptions.BadRequestException;
import it.epicode.exceptions.NotFoundException;
import it.epicode.payload.PrenotazioneRegistrationPayload;
import it.epicode.postazione.Postazione;
import it.epicode.postazione.PostazioneService;
import it.epicode.utente.Utente;
import it.epicode.utente.UtenteService;

@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	@Autowired
	UtenteService utenteService;

	@Autowired
	PostazioneService postazioneService;

	public Prenotazione create(PrenotazioneRegistrationPayload body) {
		Utente u = utenteService.findById(body.getUtenteId());
		Postazione postazione = postazioneService.findById(body.getPostazioneId());

		prenotazioneRepo.findByUtenteIdAndDataPrenotazione(body.getUtenteId(), body.getDataPrenotazione())
				.ifPresent(prenotazione -> {
					throw new BadRequestException("Non è possibile effettuare più prenotazioni per la stessa data!");
				});

		prenotazioneRepo.findByPostazioneIdAndDataPrenotazione(body.getPostazioneId(), body.getDataPrenotazione())
				.ifPresent(prenotazione -> {
					throw new BadRequestException("Postazione non disponibile per la data indicata!");
				});

		return prenotazioneRepo.save(new Prenotazione(u, postazione, LocalDate.now()));
	}

	public List<Prenotazione> find() {
		return prenotazioneRepo.findAll();
	}

	public Prenotazione findById(UUID id) throws NotFoundException {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata!"));
	}

	public Prenotazione findByIdAndUpdate(UUID id, Prenotazione p) throws NotFoundException {
		Prenotazione found = this.findById(id);

		found.setId(id);
		found.setUtente(p.getUtente());
		found.setPostazione(p.getPostazione());
		found.setDataPrenotazione(p.getDataPrenotazione());

		return prenotazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepo.delete(found);
	}

}
