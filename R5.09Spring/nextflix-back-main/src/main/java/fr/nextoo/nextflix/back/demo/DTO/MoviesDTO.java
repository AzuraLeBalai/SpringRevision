package fr.nextoo.nextflix.back.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesDTO {
	@JsonProperty("results")
	private List<MovieDTO> mooviesDTO;

	public MoviesDTO() {
	}

	public MoviesDTO(List<MovieDTO> mooviesDTO) {
		this.mooviesDTO = mooviesDTO;
	}


	public List<MovieDTO> getMooviesDTO() {
		return this.mooviesDTO;
	}
}
