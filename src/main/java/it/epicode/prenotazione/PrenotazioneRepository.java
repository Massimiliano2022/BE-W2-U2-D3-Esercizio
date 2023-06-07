package it.epicode.prenotazione;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

	Optional<Prenotazione> findByUtenteIdAndDataPrenotazione(UUID idUtente, LocalDate dataPrenotazione);

	Optional<Prenotazione> findByPostazioneIdAndDataPrenotazione(UUID idPostazione, LocalDate dataPrenotazione);

}
