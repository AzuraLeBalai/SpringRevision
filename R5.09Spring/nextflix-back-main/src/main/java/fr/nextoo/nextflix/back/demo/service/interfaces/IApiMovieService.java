package fr.nextoo.nextflix.back.demo.service.interfaces;

import fr.nextoo.nextflix.back.demo.model.ActorModel;
import fr.nextoo.nextflix.back.demo.model.GenresModel;
import fr.nextoo.nextflix.back.demo.model.MoviesModel;
import fr.nextoo.nextflix.back.demo.model.PreferenceModel;

public interface IApiMovieService {
	MoviesModel getMooviesByProfile();

	GenresModel getGenresByAPI();

	ActorModel getActorByNameFromAPI(String name);
}
