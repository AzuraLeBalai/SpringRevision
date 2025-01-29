package fr.nextoo.nextflix.back.demo.DTO.exit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreExitDTO {
	@JsonProperty("id")
	private int id;
	@JsonProperty("name")
	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
