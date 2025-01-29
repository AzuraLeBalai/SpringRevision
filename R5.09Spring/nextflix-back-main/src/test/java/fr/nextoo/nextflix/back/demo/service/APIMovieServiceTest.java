package fr.nextoo.nextflix.back.demo.service;

import fr.nextoo.nextflix.back.demo.model.GenreModel;
import fr.nextoo.nextflix.back.demo.model.GenresModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class APIMovieServiceTest {


//	@Test
//	public GenresModel getGenresByAPI() {
//		GenresModel genresModel = new GenresModel();
//		Collection<GenreModel> genresList = new ArrayList<>();
//		genresList.add(makeGenreModel(28,"Action"));
//		genresList.add(makeGenreModel(12,"Adventure"));
//		genresList.add(makeGenreModel(16,"Animation"));
//	}

	public GenreModel makeGenreModel(int id, String name){
		GenreModel genreModel = new GenreModel();
		genreModel.setId(id);
		genreModel.setName(name);
		return genreModel;
	}
}
