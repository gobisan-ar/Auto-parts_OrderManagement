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

import com.autoparts.model.CustomerOrder;
import com.autoparts.model.Invoice;
import com.autoparts.model.ShippingZone;

/**
 * Servlet implementation class InvoiceServlet
 */
@WebServlet("/generateInvoice")
public class InvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvoiceServlet() {
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

		case "/generateInvoice":
			try {
				generateInvoice(request, response);
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
	
	private void generateInvoice(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		
		int oid = Integer.parseInt(request.getParameter("orderID"));
		double amount = Double.parseDouble(request.getParameter("payment"));
		String date = request.getParameter("date");


		Invoice invoice = new Invoice(oid, amount, date);

		request.setAttribute("invoice", invoice);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/invoice.jsp");

		dispatcher.forward(request, response);
	}

}
