package fr.nextoo.nextflix.back.demo.entities.exit;

import java.util.List;

public class UserExitDTO {
	private String username;
	private String password;
	private int id;
	private List<PreferencesExitDTO> preferences;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PreferencesExitDTO> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<PreferencesExitDTO> preferences) {
		this.preferences = preferences;
	}
}
