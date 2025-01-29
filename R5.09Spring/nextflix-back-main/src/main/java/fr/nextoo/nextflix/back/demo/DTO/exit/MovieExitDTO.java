package fr.nextoo.nextflix.back.demo.DTO.exit;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

public class MovieExitDTO {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public void setGenreIds(int[] genreIds) {
		this.genreIds = genreIds;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}
