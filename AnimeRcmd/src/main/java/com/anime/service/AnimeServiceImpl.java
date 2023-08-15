package com.anime.service;

import java.util.List;

import com.anime.dao.AnimeDaoImpl;
import com.anime.dao.IAnimeDao;
import com.anime.model.Anime;

public class AnimeServiceImpl implements IAnimeService {

	@Override
	public void addAnime(Anime anime) {
		// TODO Auto-generated method stub
		IAnimeDao animeservice = new AnimeDaoImpl();
		animeservice.addAnime(anime);
		
	}

	@Override
	public List<Anime> searchAnime(String searchField) {
		// TODO Auto-generated method stub
		IAnimeDao animeservice = new AnimeDaoImpl();
		return animeservice.searchAnime(searchField);
	}

	

}
