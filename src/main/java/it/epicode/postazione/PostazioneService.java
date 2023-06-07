package it.epicode.postazione;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.exceptions.NotFoundException;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepo;

	public Postazione create(Postazione p) {
		return postazioneRepo.save(p);
	}

	public List<Postazione> find() {
		return postazioneRepo.findAll();
	}

	public Postazione findById(UUID id) throws NotFoundException {
		return postazioneRepo.findById(id).orElseThrow(() -> new NotFoundException("Postazione non trovata!"));
	}

	public Postazione findByIdAndUpdate(UUID id, Postazione p) throws NotFoundException {
		Postazione found = this.findById(id);

		found.setId(id);
		found.setCitta(p.getCitta());
		found.setTipoPostazione(p.getTipoPostazione());
		found.setNumeroMassimo(p.getNumeroMassimo());

		return postazioneRepo.save(found);
	}

	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Postazione found = this.findById(id);
		postazioneRepo.delete(found);
	}

}
