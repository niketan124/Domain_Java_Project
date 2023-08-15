package com.anime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anime.db.DbConnection;
import com.anime.model.Anime;
import com.anime.util.Queries;

public class AnimeDaoImpl implements IAnimeDao {

	@Override
	public void addAnime(Anime anime) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("In DAO IMPL");
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.INSERTQUERY);) {
			ps.setString(1, anime.getAnimeName());
			ps.setString(2, anime.getImage());
			ps.setString(3, anime.getGenre());
			ps.setInt(4, anime.getRating());
			ps.setString(5, anime.getDescription());

			ps.execute();
			System.out.println("Anime added successfully...");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public List<Anime> searchAnime(String searchField) {
		// TODO Auto-generated method stub
		List<Anime> animeList = new ArrayList<Anime>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("In SearchField IMPL");
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement ps = connection.prepareStatement(Queries.QUERYBYSEARCH);) {
			ps.setString(1, searchField);
			ps.setString(2, searchField);

			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					String name = rs.getString("animeName");
					String image = rs.getString("image");
					String genre = rs.getString("genre");
					Integer rating = rs.getInt("rating");
					String description = rs.getString("description");
					Anime anime = new Anime(name, image, genre, rating, description);
					animeList.add(anime);
					System.out.println(anime.toString());
				}
			}
			
			System.out.println("Anime found successfully...");
			return animeList;
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;

	}

}
