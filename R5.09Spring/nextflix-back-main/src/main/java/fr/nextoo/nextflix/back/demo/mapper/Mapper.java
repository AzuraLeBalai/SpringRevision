package fr.nextoo.nextflix.back.demo.mapper;

import fr.nextoo.nextflix.back.demo.DTO.*;
import fr.nextoo.nextflix.back.demo.DTO.exit.GenreExitDTO;
import fr.nextoo.nextflix.back.demo.DTO.exit.GenresExitDTO;
import fr.nextoo.nextflix.back.demo.DTO.exit.MovieExitDTO;
import fr.nextoo.nextflix.back.demo.config.DataBase;
import fr.nextoo.nextflix.back.demo.entities.DTO.NewPreferenceList;
import fr.nextoo.nextflix.back.demo.entities.Preference;
import fr.nextoo.nextflix.back.demo.entities.User;
import fr.nextoo.nextflix.back.demo.entities.exit.PreferencesExitDTO;
import fr.nextoo.nextflix.back.demo.entities.exit.UserExitDTO;
import fr.nextoo.nextflix.back.demo.model.*;
import fr.nextoo.nextflix.back.demo.model.enums.TypePreferencesMovie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Mapper implements IMapper {
	DataBase dataBase = DataBase.getInstance();

	@Override
	public UserModel userEntitieToModel(User userEntitie) {
		UserModel userModel = new UserModel();
		userModel.setUserName(userEntitie.getUserName());
		userModel.setId(userEntitie.getId());
		userModel.setPassword(userEntitie.getPassword());
		if (userEntitie.getPreferences() != null) {
			userModel.setPreferences(userEntitie.getPreferences().stream().map(this::preferencesEntityToModel).toList());
		}
		return userModel;
	}

	@Override
	public PreferenceModel preferencesEntityToModel(Preference preference) {
		PreferenceModel preferenceModel = new PreferenceModel();
		preferenceModel.setId(preference.getId());
		preferenceModel.setName(preference.getName());
		preferenceModel.setType(TypePreferencesMovie.fromPreferenceTypeFullName(preference.getType()));
		preferenceModel.setIdUser(preference.getUser().getId());
		return preferenceModel;
	}

	@Override
	public UserExitDTO userModelToUserExitDTO(UserModel userModel) {
		UserExitDTO exitDTO = new UserExitDTO();
		exitDTO.setId(userModel.getId());
		exitDTO.setUsername(userModel.getUserName());
		exitDTO.setPassword(userModel.getPassword());
		if (userModel.getPreferences() != null) {
			exitDTO.setPreferences(userModel.getPreferences().stream().map(this::preferenceModelToPreferenceExitDTO).toList());
		}
		return exitDTO;
	}

	@Override
	public PreferencesExitDTO preferenceModelToPreferenceExitDTO(PreferenceModel preferenceModel) {
		PreferencesExitDTO exitDTO = new PreferencesExitDTO();
		exitDTO.setId(preferenceModel.getId());
		exitDTO.setIdUser(preferenceModel.getIdUser());
		exitDTO.setName(preferenceModel.getName());
		exitDTO.setType(preferenceModel.getType().getPreferenceTypeFullName());
		return exitDTO;
	}

	@Override
	public List<PreferenceModel> newPreferenceToPreferenceModelList(NewPreferenceList preferenceList) {
		List<PreferenceModel> preferenceModelList = new ArrayList<>();
		if (preferenceList.getActors() != null && !preferenceList.getActors().isEmpty()) {
			for (int i = 0; i < preferenceList.getActors().size(); i++) {
				preferenceModelList.add(new PreferenceModel(dataBase.getCurrentIdSession(), TypePreferencesMovie.actor, preferenceList.getActors().get(i)));
			}
		}
		if(preferenceList.getGenres() != null && !preferenceList.getGenres().isEmpty()){
			for (int i = 0 ; i < preferenceList.getGenres().size(); i ++){
				preferenceModelList.add(new PreferenceModel(dataBase.getCurrentIdSession(), TypePreferencesMovie.genre,preferenceList.getGenres().get(i)));
			}
		}


		return preferenceModelList;
	}

	@Override
	public MovieModel moovieDTOToModel(MovieDTO moovieDTO){
		MovieModel movieModel = new MovieModel();
		movieModel.setId(moovieDTO.getId());
		movieModel.setAdult(moovieDTO.isAdult());
		movieModel.setGenreIds(moovieDTO.getGenreIds());
		movieModel.setOverview(moovieDTO.getOverview());
		movieModel.setPosterPath(moovieDTO.getPosterPath());
		movieModel.setOriginalTitle(moovieDTO.getOriginalTitle());
		movieModel.setReleaseDate(LocalDate.parse(moovieDTO.getReleaseDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		movieModel.setVoteAverage(moovieDTO.getVoteAverage());
		movieModel.setVoteCount(moovieDTO.getVoteCount());
		return movieModel;
	}

	@Override
	public MovieExitDTO moovieModelToExitDTO(MovieModel movieModel){
		MovieExitDTO movieExitDTO = new MovieExitDTO();
		movieExitDTO.setId(movieModel.getId());
		movieExitDTO.setAdult(movieModel.isAdult());
		movieExitDTO.setGenreIds(movieModel.getGenreIds());
		movieExitDTO.setOverview(movieModel.getOverview());
		movieExitDTO.setPosterPath(movieModel.getPosterPath());
		movieExitDTO.setOriginalTitle(movieModel.getOriginalTitle());
		movieExitDTO.setReleaseDate(movieModel.getReleaseDate().toString());
		movieExitDTO.setVoteAverage(movieModel.getVoteAverage());
		movieExitDTO.setVoteCount(movieModel.getVoteCount());
		return movieExitDTO;
	}

	@Override
	public MoviesModel mooviesDTOToModel(MoviesDTO moviesDTO){
		MoviesModel moviesModel = new MoviesModel();
		moviesModel.setMoovieModels(moviesDTO.getMooviesDTO()
				.stream()
				.map(this::moovieDTOToModel)
				.toList());
		List<MovieModel> moovieModelList = new ArrayList<>();
		for (int i = 0; i < 10 && i != moviesModel.getMoovieModels().size(); i ++){
			moovieModelList.add(moviesModel.getMoovieModels().get(i));
		}
		moviesModel.setMoovieModels(moovieModelList);
		return moviesModel;
	}

	@Override
	public GenresModel genresDTOToModel(GenresDTO genresDTO){
		GenresModel genresModel = new GenresModel();
		genresModel.setListGenreModel(genresDTO.getListGenreDTO()
				.stream()
				.map(this::genreDTOToModel)
				.toList());
		return genresModel;
	}

	@Override
	public GenreModel genreDTOToModel(GenreDTO genreDTO) {
		GenreModel genreModel = new GenreModel();
		genreModel.setId(genreDTO.getId());
		genreModel.setName(genreDTO.getName());
		return genreModel;
	}

	@Override
	public GenresExitDTO genresModelToExitDTO(GenresModel genresModel){
		GenresExitDTO genresExitDTO = new GenresExitDTO();
		genresExitDTO.setListGenreExitDTO(genresModel.getListGenreModel()
				.stream()
				.map(this::genreModelToExitDTO)
				.toList());
		return genresExitDTO;
	}

	@Override
	public GenreExitDTO genreModelToExitDTO(GenreModel genreModel) {
		GenreExitDTO genreExitDTO = new GenreExitDTO();
		genreExitDTO.setId(genreModel.getId());
		genreExitDTO.setName(genreModel.getName());
		return genreExitDTO;
	}

	@Override
	public ActorModel actorDTOToModel(ActorDTO actorDTO){
		ActorModel actorModel = new ActorModel();
		actorModel.setId(actorDTO.getId());
		actorModel.setName(actorDTO.getName());
		return actorModel;
	}

	@Override
	public ActorModel actorResDTOToActorModel(ActorResDTO actorResDTO){
		ActorModel actorModel = new ActorModel();
		if (actorResDTO.getActorResDTO().isEmpty()){
			actorModel.setId(0);
			actorModel.setName("");
		}else {
			actorModel.setId(actorResDTO.getActorResDTO().get(0).getId());
			actorModel.setName(actorResDTO.getActorResDTO().get(0).getName());
		}
		return actorModel;
	}
}
