package it.epicode.postazione;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

}
