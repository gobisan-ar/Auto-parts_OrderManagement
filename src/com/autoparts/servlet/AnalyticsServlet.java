package com.autoparts.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.autoparts.model.Analytics;
import com.autoparts.model.CustomerOrder;
import com.autoparts.service.AnalyticsService;
import com.autoparts.service.CustomerOrderService;

/**
 * Servlet implementation class InvoiceServlet
 */
@WebServlet("/analyticsReport")
public class AnalyticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getServletPath();

		System.out.println(action);

		switch(action) {

		case "/analyticsReport":
			try {
				showAnalyticsReport(request, response);
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
		doGet(request, response);
	}
	
	/*
	private void showAnalyticsReport(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/analytics.jsp");

		dispatcher.forward(request, response);
	}*/
	
	// list new Order
		private void showAnalyticsReport(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
			AnalyticsService analyticsDAO = new AnalyticsService();
			
		Analytics report = analyticsDAO.showAnalytics();

			request.setAttribute("report", report);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/analytics.jsp");

			dispatcher.forward(request, response);
		}

}
