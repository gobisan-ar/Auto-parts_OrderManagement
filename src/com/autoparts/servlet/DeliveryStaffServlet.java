package com.autoparts.servlet;

import com.autoparts.model.DeliveryStaff;
import com.autoparts.service.DeliveryStaffService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShippingZoneServlet
 */
@WebServlet(urlPatterns = {"/listStaff", "/insertStaff", "/updateStaff", "/deleteStaff"})
public class DeliveryStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeliveryStaffService dstaffDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeliveryStaffServlet() {
		this.dstaffDAO = new DeliveryStaffService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath()); 

		String action = request.getServletPath();

		System.out.println(action);

		switch(action) {
		case "/insertStaff":
			try {
				insertDeliveryStaff(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/updateStaff":
			try {
				updateDeliveryStaff(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/deleteStaff":
			try {
				deleteDeliveryStaff(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/findStaff":
			try {
				selectDeliveryStaff(request, response);
			} catch (SQLException | IOException | ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "/listStaff":
			try {
				listDeliveryStaff(request, response);
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
		this.doGet(request, response);
	}

	// insert shipping zone
	private void insertDeliveryStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String nic = request.getParameter("nic");

		DeliveryStaff dstaff = new DeliveryStaff(fname, lname, email, mobile, nic);

		dstaffDAO.insertDeliveryStaff(dstaff);

		response.sendRedirect("listStaff");
	}

	// update Delivery Staff
	private void updateDeliveryStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int sid = Integer.parseInt(request.getParameter("sid"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String nic = request.getParameter("nic");
		String status =request.getParameter("status");

		DeliveryStaff dstaff = new DeliveryStaff(sid, fname, lname, email, mobile, nic, status);

		dstaffDAO.updateDeliveryStaff(dstaff);

		response.sendRedirect("listStaff");
	}

	// delete DeliveryStaff
	private void deleteDeliveryStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int sid = Integer.parseInt(request.getParameter("sid"));

		dstaffDAO.deleteDeliveryStaff(sid);

		response.sendRedirect("listStaff");
	}

	// list Delivery Staff
	private void listDeliveryStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<DeliveryStaff> staffList = dstaffDAO.selectallDeliveryStaffs();

		request.setAttribute("staffList", staffList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/delivery_staff.jsp");

		dispatcher.forward(request, response);
	}

	// find Delivery Staff
	private void selectDeliveryStaff(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int sid = Integer.parseInt(request.getParameter("sid"));

		DeliveryStaff dstaff = new DeliveryStaff(dstaffDAO.selectDeliveryStaff(sid));

		request.setAttribute("dtaff", dstaff);

		response.sendRedirect("listStaff");
	}
}
