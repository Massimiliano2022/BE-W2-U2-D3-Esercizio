package it.epicode.utente;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utenti")
@Data
@NoArgsConstructor

public class Utente {

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;

	public Utente(String nome, String cognome, String email) {
		setNome(nome);
		setCognome(cognome);
		setEmail(email);
	}
}
