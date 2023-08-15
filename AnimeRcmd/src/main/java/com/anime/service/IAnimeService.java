package com.anime.service;

import java.util.List;

import com.anime.model.Anime;

public interface IAnimeService {
	void addAnime(Anime anime);
	
	List<Anime> searchAnime(String searchField);

}
