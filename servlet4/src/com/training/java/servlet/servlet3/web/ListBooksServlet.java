package com.training.java.servlet.servlet3.web;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.java.servlet.servlet3.domain.Book;
import com.training.java.servlet.servlet3.domain.BookDAO;
import com.training.java.servlet.servlet3.domain.BookDAOJDBCImpl;
import com.training.java.servlet.servlet3.domain.DAOException;

/**
 * Servlet implementation class ListMoviesServlet
 */
public class ListBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBooksServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maxBooksDisplayedStr = getServletConfig().getInitParameter("maxBooksDisplayed");
		int maxBooksDisplayed = Integer.parseInt(maxBooksDisplayedStr);
		
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String dbUsername = getServletContext().getInitParameter("dbUsername");
		String dbPassword = getServletContext().getInitParameter("dbPassword");
		
		BookDAO dao = new BookDAOJDBCImpl(jdbcURL, dbUsername, dbPassword);
		
		List<Book> books = Collections.emptyList();
		try {
			books = dao.getAllBooks();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("BOOKS_TO_DISPLAY", books);
		request.setAttribute("MAX_BOOKS_DISPLAYED", maxBooksDisplayed);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/display");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost called on ListBook");
		
		
	}

}