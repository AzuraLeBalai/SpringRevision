package fr.nextoo.nextflix.back.demo.service.interfaces;

import fr.nextoo.nextflix.back.demo.model.PreferenceModel;

import java.util.List;

public interface IPreferenceService {
	List<PreferenceModel> getPreferenceModelForCurrentUser();

	List<PreferenceModel> updatePreferenceList(List<PreferenceModel> newPreferences);

	List<PreferenceModel> addPreferenceList(List<PreferenceModel> newPreferences);

	List<PreferenceModel> deletePreferenceList(List<PreferenceModel> preferencesToDelete);

	List<PreferenceModel> getPreferencesFromUserIdOrderByType(int id);

	PreferenceModel postWithoutMovie(int movieId);
}
