package fr.nextoo.nextflix.back.demo.model;

import java.util.List;

public class UserModel {
	private int id;
	private String userName;
	private String password;
	private List<PreferenceModel> preferences;

	public UserModel() {
	}

	@Override
	public boolean equals(Object userModel) {
		if (userModel instanceof UserModel) {
			return ((UserModel) userModel).getId() == this.getId();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PreferenceModel> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<PreferenceModel> preferences) {
		this.preferences = preferences;
	}
}
