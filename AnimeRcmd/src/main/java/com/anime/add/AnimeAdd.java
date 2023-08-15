package com.anime.add;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.anime.db.DbConnection;
import com.anime.model.Anime;
import com.anime.service.AnimeServiceImpl;
import com.anime.service.IAnimeService;
import com.mysql.cj.jdbc.Blob;

/**
 * Servlet implementation class AnimeAdd
 */
@MultipartConfig
@WebServlet("/AnimeAdd")
public class AnimeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAnimeService animeService = new AnimeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnimeAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("animename");
		String image = request.getParameter("image");
		String genre = request.getParameter("genre");
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String description = request.getParameter("description");
		System.out.println(image);
		Part file = request.getPart("image");

		String imageFileName = file.getSubmittedFileName();

		String uploadPath = "C:/Users/AD35995/training/DomainProject/AnimeRcmd/src/main/webapp/dbImages/"
				+ imageFileName;

		try {
			FileOutputStream fos = new FileOutputStream(uploadPath);

			InputStream is = file .getInputStream();

			byte data[] = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println(uploadPath);
		System.out.println(name);
		System.out.println(image);
		request.setAttribute("image", imageFileName);

//		List<Anime> animeList = new ArrayList<Anime>();
		Anime anime = new Anime(name, imageFileName, genre, rating, description);
		System.out.println(anime.getImage());
		request.setAttribute("anime", anime);
		animeService.addAnime(anime);
		
		response.sendRedirect("index.jsp");

	}

}
