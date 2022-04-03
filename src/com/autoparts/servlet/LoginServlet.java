package com.autoparts.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.autoparts.model.User;
import com.autoparts.service.UserService;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(urlPatterns = {"/loginForm", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		switch(action) {
		
		case "/loginForm":
			try {
				loginForm(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;	

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		System.out.println(action+"post");

		switch(action) {
		
		case "/login":
			try {
				checkLogin(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;	

		default:
			break;
		}
	}

	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/login.jsp");

		dispatcher.forward(request, response);
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
         
        UserService userDao = new UserService();
         
        try {
            User user = userDao.checkLogin(email, password);
             
            if (user != null) {
                request.setAttribute("user", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/view/analytics.jsp");
                dispatcher.forward(request, response);
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher( "/WEB-INF/view/login.jsp");
                dispatcher.forward(request, response);
            }    
        } catch (Exception e) {
            throw new ServletException(e);
        }
	}

}
