package fr.nextoo.nextflix.back.demo.controller;

import fr.nextoo.nextflix.back.demo.DTO.exit.GenreExitDTO;
import fr.nextoo.nextflix.back.demo.DTO.exit.MovieExitDTO;
import fr.nextoo.nextflix.back.demo.exeption.BadInputException;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.service.ApiMoviesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api-movies")
public class ApiMoviesController {

	private final Mapper mapper = new Mapper();
	private final ApiMoviesService apiMoviesService;

	public ApiMoviesController(@Qualifier("apiMoviesService") ApiMoviesService apiMoviesService) {
		this.apiMoviesService = apiMoviesService;
	}

	@GetMapping("/get-movies-by-profile")
	public ResponseEntity<List<MovieExitDTO>> getMovieFromUserPreference() throws BadInputException {
		return ResponseEntity.ok(this.apiMoviesService.getMooviesByProfile().getMoovieModels().stream().map(mapper::moovieModelToExitDTO).toList());
	}

	@GetMapping("/get-genre-list")
	public ResponseEntity<List<GenreExitDTO>> getGenreFromAPI() throws BadInputException {
		return ResponseEntity.ok(this.apiMoviesService.getGenresByAPI().getListGenreModel().stream().map(mapper::genreModelToExitDTO).toList());
	}
}