package fr.nextoo.nextflix.back.demo.model.enums;

public enum TypePreferencesMovie {
	actor("with_cast"),
	genre("with_genres"),
	movieSkip("without_movie");

	private String preferenceTypeFullName;

	TypePreferencesMovie(String preferenceTypeFullName) {
		this.preferenceTypeFullName = preferenceTypeFullName;
	}

	public String getPreferenceTypeFullName() {
		return preferenceTypeFullName;
	}

	public static TypePreferencesMovie fromPreferenceTypeFullName(String fullName) {
		for (TypePreferencesMovie preferenceTypeFilm : TypePreferencesMovie.values()) {
			if (preferenceTypeFilm.getPreferenceTypeFullName().equals(fullName)) {
				return preferenceTypeFilm;
			}
		}
		throw new IllegalArgumentException("No matching day found for preference: " + fullName);
	}
}
