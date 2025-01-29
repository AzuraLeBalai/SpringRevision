package fr.nextoo.nextflix.back.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorDTO {
	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private int id;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
