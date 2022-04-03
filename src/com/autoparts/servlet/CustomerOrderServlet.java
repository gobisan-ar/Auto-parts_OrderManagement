package com.autoparts.servlet;

import com.autoparts.model.CustomerOrder;
import com.autoparts.model.PendingOrder;
import com.autoparts.model.ShippedOrder;
import com.autoparts.service.CustomerOrderService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerOrderServlet
 */
@WebServlet(urlPatterns = {"/listOrder", "/updateOrder", "/deleteOrder", "/acceptOrder", "/shipOrder", "/holdOrder", "/shippedOrder", "/pendingOrder", "/newOrder"})
public class CustomerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerOrderService corderDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerOrderServlet() {
		this.corderDAO = new CustomerOrderService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();

		System.out.println(action);

		switch(action) {

		case "/listOrder":
			try {
				listCustomerOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;	

		case "/shippedOrder":
			try {
				listShippedOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/pendingOrder":
			try {
				listPendingOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/newOrder":
			try {
				listNewOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/deleteOrder":
			try {
				deleteCustomerOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/acceptOrder":
			try {
				acceptCustomerOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
			
		case "/shipOrder":
			try {
				shipCustomerOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;
			
		case "/holdOrder":
			try {
				holdCustomerOrder(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}

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


	// list Customer Order
	private void listCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<CustomerOrder> orderList = corderDAO.selectallCustomerOrders();

		request.setAttribute("orderList", orderList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/all_order.jsp");

		dispatcher.forward(request, response);
	}


	// list shipped Order
	private void listShippedOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<ShippedOrder> shippedOrder = corderDAO.selectallShippedOrders();

		request.setAttribute("shippedOrder", shippedOrder);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/shipped_order.jsp");

		dispatcher.forward(request, response);
	}

	// list pending Order
	private void listPendingOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<PendingOrder> pendingOrder = corderDAO.selectallPendingOrders();

		request.setAttribute("pendingOrder", pendingOrder);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/pending_order.jsp");

		dispatcher.forward(request, response);
	}

	// list new Order
	private void listNewOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<CustomerOrder> newOrder = corderDAO.selectallNewOrders();

		request.setAttribute("newOrder", newOrder);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/new_order.jsp");

		dispatcher.forward(request, response);
	}

	// delete customer order
	private void deleteCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int oid = Integer.parseInt(request.getParameter("oid"));

		corderDAO.deleteCustomerOrder(oid);

		response.sendRedirect("pendingOrder");
	}

	// accept customer order
	private void acceptCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int oid = Integer.parseInt(request.getParameter("oid"));

		corderDAO.acceptCustomerOrder(oid);

		response.sendRedirect("pendingOrder");
	}
	
	// ship customer order
		private void shipCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
			int oid = Integer.parseInt(request.getParameter("oid"));
			String sid = request.getParameter("sid");

			corderDAO.shipCustomerOrder(oid, sid);

			response.sendRedirect("newOrder");
		}
		
		// hold customer order
				private void holdCustomerOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
					int oid = Integer.parseInt(request.getParameter("oid"));
					String reason = request.getParameter("preason");

					corderDAO.holdCustomerOrder(oid, reason);

					response.sendRedirect("newOrder");
				}
}
