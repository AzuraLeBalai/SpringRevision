package fr.nextoo.nextflix.back.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenresDTO {
	@JsonProperty("genres")
	private List<GenreDTO> listGenreDTO;

	public List<GenreDTO> getListGenreDTO() {
		return listGenreDTO;
	}
}
