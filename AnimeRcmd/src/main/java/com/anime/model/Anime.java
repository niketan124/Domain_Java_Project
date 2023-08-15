package com.anime.model;

import com.mysql.cj.jdbc.Blob;

public class Anime {
	private String animeName;
	private String image;
	private String genre;
	private Integer rating;
	private String description;

	public String getAnimeName() {
		return animeName;
	}

	public void setAnimeName(String animeName) {
		this.animeName = animeName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Anime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anime(String animeName, String image, String genre, Integer rating, String description) {
		super();
		this.animeName = animeName;
		this.image = image;
		this.genre = genre;
		this.rating = rating;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Anime [animeName=" + animeName + ", image=" + image + ", genre=" + genre + ", rating=" + rating
				+ ", description=" + description + "]";
	}

}
