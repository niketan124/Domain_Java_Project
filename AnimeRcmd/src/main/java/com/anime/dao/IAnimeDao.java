package com.anime.dao;

import java.util.List;

import com.anime.model.Anime;

public interface IAnimeDao {
	
	void addAnime(Anime anime);
	
	List<Anime> searchAnime(String searchField);

}
