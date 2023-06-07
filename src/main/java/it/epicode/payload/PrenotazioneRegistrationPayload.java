package it.epicode.payload;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;

@Getter
public class PrenotazioneRegistrationPayload {
	UUID utenteId;
	UUID postazioneId;
	LocalDate dataPrenotazione;
}
