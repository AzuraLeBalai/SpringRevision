package fr.nextoo.nextflix.back.demo.entities.DTO;

import java.util.List;

public class NewPreferenceList {
	List<String> actors;
	List<String> genres;


	public List<String> getActors() {
		return actors;
	}

	public void addActor(String actor) {
		this.actors.add(actor);
	}

	public List<String> getGenres() {
		return genres;
	}

	public void addGenres(String genre) {
		this.genres.add(genre);
	}
}
