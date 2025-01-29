package fr.nextoo.nextflix.back.demo.model;

import fr.nextoo.nextflix.back.demo.model.enums.TypePreferencesMovie;

public class PreferenceModel {
	private int id,idUser;
	private TypePreferencesMovie type;
	private String name;

	public PreferenceModel() {
	}

	public PreferenceModel(int idUser, TypePreferencesMovie type, String name) {
		this.idUser = idUser;
		this.type = type;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public TypePreferencesMovie getType() {
		return type;
	}

	public void setType(TypePreferencesMovie type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
