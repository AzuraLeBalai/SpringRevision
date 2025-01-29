package fr.nextoo.nextflix.back.demo.service;

import fr.nextoo.nextflix.back.demo.entities.Preference;
import fr.nextoo.nextflix.back.demo.entities.User;
import fr.nextoo.nextflix.back.demo.model.enums.TypePreferencesMovie;

import java.util.ArrayList;
import java.util.List;

public class ExpectedData {

	private List<User> userList = new ArrayList<>();

	private List<Preference> preferenceList1 = new ArrayList<>();
	private List<Preference> preferenceList2 = new ArrayList<>();
	private List<Preference> preferenceList3 = new ArrayList<>();


	public ExpectedData() {
		initUserList();
		initPreferenceList();
	}

	private void initPreferenceList() {
		preferenceList1.add(makePreference(1,"10859",TypePreferencesMovie.actor,userList.get(1)));
		preferenceList2.add(makePreference(2,"10859",TypePreferencesMovie.actor,userList.get(2)));
		preferenceList2.add(makePreference(3,"2231",TypePreferencesMovie.actor,userList.get(2)));
		preferenceList3.add(makePreference(4,"28",TypePreferencesMovie.genre,userList.get(3)));
		preferenceList3.add(makePreference(5,"12",TypePreferencesMovie.genre,userList.get(3)));
	}

	private void initUserList() {
		this.userList.add(makeUser(1,"","user1",preferenceList1));
		this.userList.add(makeUser(2,"","user2",preferenceList2));
		this.userList.add(makeUser(3,"","user3",preferenceList3));
	}

	public User makeUser(int id,String password, String name,List<Preference> preferences) {
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setUserName(name);
		user.setPreferences(preferences);
		return user;
	}

	public Preference makePreference(int id, String name, TypePreferencesMovie typePreferencesMovie,User user) {
		Preference preference = new Preference();
		preference.setId(id);
		preference.setName(name);
		preference.setType(typePreferencesMovie.getPreferenceTypeFullName());
		preference.setUser(user);
		return preference;
	}
}
