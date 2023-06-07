package it.epicode.prenotazione;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import it.epicode.postazione.Postazione;
import it.epicode.utente.Utente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prenotazioni")
@Data
@NoArgsConstructor

public class Prenotazione {

	@Id
	@GeneratedValue
	private UUID id;
	@OneToOne
	@JoinColumn(name = "utente_id", referencedColumnName = "id")
	@JsonManagedReference
	private Utente utente;
	@OneToOne
	@JoinColumn(name = "postazione_id", referencedColumnName = "id")
	@JsonBackReference
	private Postazione postazione;
	private LocalDate dataPrenotazione;

	public Prenotazione(Utente u, Postazione p, LocalDate dataPrenotazione) {
		setUtente(u);
		setPostazione(p);
		setDataPrenotazione(dataPrenotazione);
	}

}
