package com.anime.util;

public class Queries {
	public static final String CREATEQUERY = "create table anime (animeName varchar(200),image varchar(200), animeId integer primary key auto_increment, genre varchar(300),rating int, description varchar(200))";
	public static final String INSERTQUERY = "insert into anime(animeName, image,genre,rating, description) values(?,?,?,?,?)";
	public static final String QUERYBYSEARCH = "select * from anime where animeName=? or genre=?";
}
