package it.epicode.postazione;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postazioni")
public class PostazioneController {

	@Autowired
	private PostazioneService postazioneService;

	@GetMapping("")
	public List<Postazione> getPostazioni() {
		return postazioneService.find();
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePostazione(@RequestBody Postazione body) {
		return postazioneService.create(body);

	}

	@GetMapping("/{postazioneId}")
	public Postazione getPostazione(@PathVariable UUID postazioneId) throws Exception {
		return postazioneService.findById(postazioneId);

	}

	@PutMapping("/{postazioneId}")
	public Postazione updatePostazione(@PathVariable UUID postazioneId, @RequestBody Postazione body) throws Exception {
		return postazioneService.findByIdAndUpdate(postazioneId, body);

	}

	@DeleteMapping("/{postazioneId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazione(@PathVariable UUID postazioneId) throws Exception {
		postazioneService.findByIdAndDelete(postazioneId);
	}
}
