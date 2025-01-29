package fr.nextoo.nextflix.back.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ActorResDTO {
	@JsonProperty("results")
	private List<ActorDTO> actorResDTO;

	public List<ActorDTO> getActorResDTO() {
		return actorResDTO;
	}
}
