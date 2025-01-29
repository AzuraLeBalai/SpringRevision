package fr.nextoo.nextflix.back.demo.service;

import fr.nextoo.nextflix.back.demo.DTO.ActorResDTO;
import fr.nextoo.nextflix.back.demo.DTO.GenresDTO;
import fr.nextoo.nextflix.back.demo.DTO.MoviesDTO;
import fr.nextoo.nextflix.back.demo.config.DataBase;
import fr.nextoo.nextflix.back.demo.exeption.GlobalExeption;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.model.*;
import fr.nextoo.nextflix.back.demo.model.enums.TypePreferencesMovie;
import fr.nextoo.nextflix.back.demo.repository.PreferenceRepository;
import fr.nextoo.nextflix.back.demo.repository.UserRepository;
import fr.nextoo.nextflix.back.demo.service.interfaces.IApiMovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiMoviesService implements IApiMovieService {
	@Value("${API_URL_DISCOVER}")
	private String DISCOVER_MOVIE;
	@Value("${API_URL_GENRES}")
	private String URL_GENRES;
	@Value("${API_URL}")
	private String URL;
	@Value("${API_KEY}")
	private String API_KEY;
	@Value("${API_URL_POSTER}")
	private String URL_POSTER;
	@Value("${API_URL_ACTOR}")
	private String URL_ACTOR;
	private final RestTemplate restTemplate;
	private final Mapper mapper = new Mapper();
	private final PreferenceRepository preferenceRepository;
	private final UserRepository userRepository;
	private final DataBase dataBase;
	private final String URL_SEPARATOR = "&";
	private final String queryParam = "query=";
	private final String pageParam = "page=";
	private final String getById = "without=";

	public ApiMoviesService(@Value("${API_URL}") final String rootUrl, PreferenceRepository preferenceRepository,UserRepository userRepository) {
		this.restTemplate = new RestTemplateBuilder().rootUri(rootUrl).build();
		this.preferenceRepository = preferenceRepository;
		this.userRepository = userRepository;
		this.dataBase = DataBase.getInstance();
	}

	@Override
	public MoviesModel getMooviesByProfile() {
		//todo passer par i18n si le temps
		StringBuilder apiUrl = new StringBuilder(URL + DISCOVER_MOVIE + API_KEY + "&language=fr");

		List<PreferenceModel> preferenceModelList = this.preferenceRepository.findAllByUser_IdOrderByType(this.dataBase.getCurrentIdSession())
				.stream()
				.map(mapper::preferencesEntityToModel)
				.toList();

		List<Integer> listMovieToSkip = this.preferenceRepository.findByUser_IdAndTypeEquals(this.dataBase.getCurrentIdSession(), TypePreferencesMovie.movieSkip.getPreferenceTypeFullName())
				.stream()
				.map(preference -> Integer.parseInt(preference.getName()))
				.toList();

		//If preference is not empty in BDD, make URL with preferences in parameter
		if (!preferenceModelList.isEmpty()) {
			String actualTypeParam = preferenceModelList.get(0).getType().getPreferenceTypeFullName();
			List<String> paramValuesList = new ArrayList<>();
			for (PreferenceModel preferenceModel : preferenceModelList) {
				if (!actualTypeParam.equals(preferenceModel.getType().getPreferenceTypeFullName()) && !preferenceModel.getType().getPreferenceTypeFullName().equals(TypePreferencesMovie.movieSkip)) {
					apiUrl.append(URL_SEPARATOR).append(actualTypeParam).append("=").append(reformatTabForURL(paramValuesList));
					actualTypeParam = preferenceModel.getType().getPreferenceTypeFullName();
					paramValuesList.clear();
				}
				paramValuesList.add(preferenceModel.getName());
			}
			if (actualTypeParam.equals(TypePreferencesMovie.movieSkip) && actualTypeParam != null){
				apiUrl.append(URL_SEPARATOR).append(actualTypeParam).append("=").append(reformatTabForURL(paramValuesList));
			}

		}

		List<MovieModel> movieModelListFilter = new ArrayList<>();

		int cptPage = 1;
		boolean moviePageIsComplete = false;
		while (movieModelListFilter.size() < 10 && !moviePageIsComplete) {

			int cptMovieInCurrentPage = 0;

			MoviesDTO moviesDTO = getMoviesDTOFromAPIExt(apiUrl, cptPage);
			MoviesDTO moviesDTOFilter = new MoviesDTO(moviesDTO.getMooviesDTO()
					.stream()
					.filter(movieDTO -> !listMovieToSkip.contains(movieDTO.getId()))
					.toList());

			List<MovieModel> movieModelList = new ArrayList<>(mapper.mooviesDTOToModel(moviesDTOFilter).getMoovieModels());

			for (int i = 0; i < movieModelList.size(); i++) {
				cptMovieInCurrentPage++;
				if (movieModelList.get(i) != null) {
					MovieModel currentMovieModel = movieModelList.get(i);

					boolean canAddCurrentMovie = true;
					for (MovieModel movieModel : movieModelListFilter) {
						if (movieModel.getId() == currentMovieModel.getId() || listMovieToSkip.contains(currentMovieModel.getId())) {
							canAddCurrentMovie = false;
						}
					}
					if (canAddCurrentMovie) {
						movieModelListFilter.add(currentMovieModel);
					}
				}
			}
			if (cptMovieInCurrentPage == 1) {
				moviePageIsComplete = true;
			}
			cptPage++;
		}

		for (MovieModel movieModel : movieModelListFilter) {
			movieModel.setPosterPath(URL_POSTER + movieModel.getPosterPath());
		}

		MoviesModel moviesModelRes = new MoviesModel();
		moviesModelRes.setMoovieModels(movieModelListFilter.stream().limit(10).collect(Collectors.toList()));
		return moviesModelRes;
	}

	private MoviesDTO getMoviesDTOFromAPIExt(StringBuilder apiUrl, int cptPage) {
		ResponseEntity<MoviesDTO> responseFromAPI;
		StringBuilder apiUrlWithPage = new StringBuilder();
		apiUrlWithPage.append(apiUrl + URL_SEPARATOR + pageParam + cptPage);
		try {
			responseFromAPI = restTemplate.getForEntity(apiUrlWithPage.toString(), MoviesDTO.class);
		} catch (RuntimeException e) {
			throw new GlobalExeption("Something went wrong");
		}


		MoviesDTO moviesDTO = responseFromAPI.getBody();
		return moviesDTO;
	}

	private static CharSequence reformatTabForURL(List<String> paramValuesList) {
		return paramValuesList.toString().subSequence(1, paramValuesList.toString().length() - 1);
	}

	@Override
	public GenresModel getGenresByAPI() {
		String apiUrl = URL + URL_GENRES + API_KEY;

		ResponseEntity<GenresDTO> responseFromAPI;
		try {
			responseFromAPI = restTemplate.getForEntity(apiUrl, GenresDTO.class);
		} catch (RuntimeException e) {
			throw new GlobalExeption("Something went wrong", e);
		}

		GenresDTO genresDTO = responseFromAPI.getBody();
		return mapper.genresDTOToModel(genresDTO);
	}

	@Override
	public ActorModel getActorByNameFromAPI(String name) {
		String apiUrl = URL + URL_ACTOR + API_KEY + URL_SEPARATOR + queryParam + name;

		ResponseEntity<ActorResDTO> responseFromAPI;
		try {
			responseFromAPI = restTemplate.getForEntity(apiUrl, ActorResDTO.class);
		} catch (RuntimeException e) {
			throw new GlobalExeption("The actor " + name + " is not found");
		}

		ActorResDTO actorResDTO = responseFromAPI.getBody();
		return mapper.actorResDTOToActorModel(actorResDTO);
	}
}
