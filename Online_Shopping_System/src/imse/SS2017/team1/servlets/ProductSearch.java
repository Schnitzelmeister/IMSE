package imse.SS2017.team1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imse.SS2017.team1.searchengine.FoundResult;
import imse.SS2017.team1.searchengine.SearchEngine;
import imse.SS2017.team1.searchengine.SearchEngineRDBMS;

@WebServlet("/results")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductSearch() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SearchEngine engine = new SearchEngineRDBMS();

			String searchText = request.getParameter("search");
			int categoryId;
			try {
				categoryId = Integer.parseInt(request.getParameter("cat"));
			}
			catch(NumberFormatException e) {
				categoryId = 0;
			}
			
			int sortMode;
			try {
				sortMode = Integer.parseInt(request.getParameter("sort"));
			}
			catch(NumberFormatException e) {
				sortMode = 0;
			}
			
			int pageNumber;
			try {
				pageNumber = Integer.parseInt(request.getParameter("pnum"));
			}
			catch(NumberFormatException e) {
				pageNumber = 0;
			}

			//System.out.println("pageNumber="+pageNumber);
			FoundResult results = engine.getResults(searchText, categoryId, sortMode, pageNumber);
			
			request.setAttribute("results", results);
		    request.getRequestDispatcher("/results.jsp").forward(request, response);
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} 

	}

}
