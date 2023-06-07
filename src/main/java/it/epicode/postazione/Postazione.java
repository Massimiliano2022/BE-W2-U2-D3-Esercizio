package it.epicode.postazione;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import it.epicode.prenotazione.Prenotazione;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "postazioni")
@Data
@NoArgsConstructor

public class Postazione {

	@Id
	@GeneratedValue
	private UUID id;
	private String citta;
	private TipoPostazione tipoPostazione;
	private int numeroMassimo;
	@OneToMany
	@JoinColumn(name = "postazione_id", referencedColumnName = "id", nullable = true)
	@JsonManagedReference
	private List<Prenotazione> listaPrenotazioni;

	public Postazione(String citta, TipoPostazione tipoPostazione, int numeroMassimo) {
		setCitta(citta);
		setTipoPostazione(tipoPostazione);
		setNumeroMassimo(numeroMassimo);
	}

}
