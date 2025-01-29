package fr.nextoo.nextflix.back.demo.service;

import fr.nextoo.nextflix.back.demo.config.DataBase;
import fr.nextoo.nextflix.back.demo.entities.Preference;
import fr.nextoo.nextflix.back.demo.entities.User;
import fr.nextoo.nextflix.back.demo.mapper.Mapper;
import fr.nextoo.nextflix.back.demo.model.PreferenceModel;
import fr.nextoo.nextflix.back.demo.model.enums.TypePreferencesMovie;
import fr.nextoo.nextflix.back.demo.repository.PreferenceRepository;
import fr.nextoo.nextflix.back.demo.repository.UserRepository;
import fr.nextoo.nextflix.back.demo.service.interfaces.IPreferenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//todo revoir les pref pour pourqui c'est récréer à chaque fois même si elle exist
@Service
public class PreferenceService implements IPreferenceService {
	private final PreferenceRepository preferenceRepository;
	private final Mapper mapper = new Mapper();
	private final DataBase dataBase;
	private final UserRepository userRepository;
	private final ApiMoviesService apiMoviesService;

	public PreferenceService(PreferenceRepository preferenceRepository, DataBase dataBase, UserRepository userRepository, ApiMoviesService apiMoviesService) {
		this.preferenceRepository = preferenceRepository;
		this.dataBase = dataBase;
		this.userRepository = userRepository;
		this.apiMoviesService = apiMoviesService;
	}

	@Override
	public List<PreferenceModel> getPreferenceModelForCurrentUser() {
		return this.preferenceRepository.findAllByUser(userRepository.findById(dataBase.getCurrentIdSession()).get())
				.stream()
				.map(mapper::preferencesEntityToModel)
				.toList();
	}

	@Override
	public List<PreferenceModel> updatePreferenceList(List<PreferenceModel> newPreferences) {
		//Get the actual préférence of user
		List<PreferenceModel> oldPreferenceList = preferenceRepository.findAll()
				.stream()
				.map(mapper::preferencesEntityToModel)
				.toList();

		//Transform the actor name on id for BDD
		List<PreferenceModel> preferencesWithActor = new ArrayList<>();
		for (PreferenceModel preferenceModel : newPreferences) {
			if (preferenceModel.getType().equals(TypePreferencesMovie.actor)) {
				PreferenceModel preferencesWithActorToAdd = new PreferenceModel();
				preferencesWithActorToAdd.setType(preferenceModel.getType());
				preferencesWithActorToAdd.setName(this.apiMoviesService.getActorByNameFromAPI(preferenceModel.getName()).getId() + "");
				preferencesWithActor.add(preferencesWithActorToAdd);
			}
		}


		List<PreferenceModel> preferenceToAdd = newPreferences
				.stream()
				.filter(preferenceModel -> !oldPreferenceList.contains(preferenceModel))
				.toList();

		preferenceToAdd = preferenceToAdd.stream()
				.filter(preferenceModel -> !preferenceModel.getType().equals(TypePreferencesMovie.actor))
				.toList();
		this.addPreferenceList(preferenceToAdd);
		this.addPreferenceList(preferencesWithActor
				.stream()
				.filter(preferenceModel -> !preferenceModel.getName().equals("0"))
				.toList());

		List<PreferenceModel> preferenceToRemove = oldPreferenceList
				.stream()
				.filter(preferenceModel -> !newPreferences.contains(preferenceModel))
				.toList();

		this.deletePreferenceList(preferenceToRemove.stream().filter(preferenceModel -> !preferenceModel.getType().equals(TypePreferencesMovie.movieSkip)).toList());

		return this.getPreferenceModelForCurrentUser();
	}

	@Override
	public List<PreferenceModel> addPreferenceList(List<PreferenceModel> newPreferences) {
		List<Preference> newPreferencesEntitieList = new ArrayList<>();
		User currentUser = userRepository.findById(dataBase.getCurrentIdSession()).get();
		for (PreferenceModel preferenceModel : newPreferences) {
			newPreferencesEntitieList.add(new Preference(preferenceModel.getId(), currentUser, preferenceModel.getName(), preferenceModel.getType().getPreferenceTypeFullName()));
		}
		return preferenceRepository.saveAll(newPreferencesEntitieList)
				.stream()
				.map(mapper::preferencesEntityToModel)
				.toList();
	}

	@Override
	public List<PreferenceModel> deletePreferenceList(List<PreferenceModel> preferencesToDelete) {
		List<Preference> preferencesEntitieListToDelete = new ArrayList<>();
		User currentUser = userRepository.findById(dataBase.getCurrentIdSession()).get();
		for (PreferenceModel preferenceModel : preferencesToDelete) {
			preferencesEntitieListToDelete.add(new Preference(preferenceModel.getId(), currentUser, preferenceModel.getName(), preferenceModel.getType().getPreferenceTypeFullName()));
		}
		preferenceRepository.deleteAll(preferencesEntitieListToDelete);
		return preferencesToDelete;
	}

	@Override
	public List<PreferenceModel> getPreferencesFromUserIdOrderByType(int id) {
		return preferenceRepository.findAllByUser_IdOrderByType(id)
				.stream()
				.map(mapper::preferencesEntityToModel)
				.toList();
	}

	@Override
	public PreferenceModel postWithoutMovie(int movieId){
		Preference preference = new Preference();
		preference.setName("" + movieId);
		preference.setType(TypePreferencesMovie.movieSkip.getPreferenceTypeFullName());
		preference.setUser(userRepository.findById(dataBase.getCurrentIdSession()).get());
		preferenceRepository.save(preference);
		return mapper.preferencesEntityToModel(preference);
	}
}
