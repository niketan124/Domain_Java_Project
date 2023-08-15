package com.anime.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.anime.db.DbConnection;
import com.anime.service.AnimeServiceImpl;
import com.anime.service.IAnimeService;

public class AnimeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection connection = DbConnection.openConnection();) {
			System.out.println(connection);
			IAnimeService animeService = new AnimeServiceImpl();
			animeService.searchAnime("Naruto");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
