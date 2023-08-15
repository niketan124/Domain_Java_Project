package com.anime.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anime.model.Anime;
import com.anime.service.AnimeServiceImpl;
import com.anime.service.IAnimeService;

/**
 * Servlet implementation class AnimeSearch
 */
@WebServlet("/AnimeSearch")
public class AnimeSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAnimeService animeService = new AnimeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnimeSearch() {
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
		String searchField = request.getParameter("animename").toLowerCase();
		System.out.println(searchField);

		List<Anime> animesList = animeService.searchAnime(searchField);
		request.setAttribute("aList", animesList);
		if (animesList.size() > 1) {
			request.setAttribute("message", "Search Results Based on " + searchField + " Genre");
		} else {
			request.setAttribute("message", "Search Result on " + searchField + " Anime Name");
		}
		if (animesList.size() == 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("anime_not_found.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("search_result.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
