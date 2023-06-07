package it.epicode.utente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, UUID> {

}
