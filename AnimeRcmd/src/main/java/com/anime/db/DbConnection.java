package com.anime.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.anime.util.Queries;
import com.mysql.cj.xdevapi.Statement;

public class DbConnection {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/animedb";
		String username = "root";
		String password = "admin@123";

		try {
			connection = DriverManager.getConnection(url, username, password);
			java.sql.Statement statement = connection.createStatement();
//			statement.execute(Queries.CREATEQUERY);
//			System.out.println("Table Created Sucessfully");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

}
