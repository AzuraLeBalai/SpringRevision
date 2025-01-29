package fr.nextoo.nextflix.back.demo.mapper;

import fr.nextoo.nextflix.back.demo.DTO.*;
import fr.nextoo.nextflix.back.demo.DTO.exit.GenreExitDTO;
import fr.nextoo.nextflix.back.demo.DTO.exit.GenresExitDTO;
import fr.nextoo.nextflix.back.demo.DTO.exit.MovieExitDTO;
import fr.nextoo.nextflix.back.demo.entities.DTO.NewPreferenceList;
import fr.nextoo.nextflix.back.demo.entities.Preference;
import fr.nextoo.nextflix.back.demo.entities.User;
import fr.nextoo.nextflix.back.demo.entities.exit.PreferencesExitDTO;
import fr.nextoo.nextflix.back.demo.entities.exit.UserExitDTO;
import fr.nextoo.nextflix.back.demo.model.*;

import java.util.List;

public interface IMapper {
	UserModel userEntitieToModel(User user);

	PreferenceModel preferencesEntityToModel(Preference preference);

	UserExitDTO userModelToUserExitDTO(UserModel userModel);

	PreferencesExitDTO preferenceModelToPreferenceExitDTO(PreferenceModel preferenceModel);

	List<PreferenceModel> newPreferenceToPreferenceModelList(NewPreferenceList preferenceList);

	MovieModel moovieDTOToModel (MovieDTO moovieDTO);

	MovieExitDTO moovieModelToExitDTO(MovieModel movieModel);

	MoviesModel mooviesDTOToModel (MoviesDTO moviesDTO);

	GenresModel genresDTOToModel(GenresDTO genresDTO);

	GenreModel genreDTOToModel(GenreDTO genreDTO);

	GenresExitDTO genresModelToExitDTO(GenresModel genresModel);

	GenreExitDTO genreModelToExitDTO(GenreModel genreModel);

	ActorModel actorDTOToModel(ActorDTO actorDTO);

	ActorModel actorResDTOToActorModel(ActorResDTO actorResDTO);
}
