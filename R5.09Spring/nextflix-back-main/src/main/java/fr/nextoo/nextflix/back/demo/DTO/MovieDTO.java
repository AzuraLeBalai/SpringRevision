package fr.nextoo.nextflix.back.demo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDTO {
	@JsonProperty("id")
	private int id;
	@JsonProperty("original_title")
	private String originalTitle ;
	@JsonProperty("vote_average")
	private double voteAverage;
	@JsonProperty("vote_count")
	private int voteCount;
	@JsonProperty("adult")
	private boolean adult;
	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("genre_ids")
	private int[] genreIds;
	@JsonProperty("overview")
	private String overview;
	@JsonProperty("release_date")
	private String releaseDate;

	public int getId() {
		return id;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public boolean isAdult() {
		return adult;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public int[] getGenreIds() {
		return genreIds;
	}

	public String getOverview() {
		return overview;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
}
