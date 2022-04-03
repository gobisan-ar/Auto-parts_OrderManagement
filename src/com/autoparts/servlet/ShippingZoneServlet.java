package com.autoparts.servlet;

import com.autoparts.model.ShippingZone;
import com.autoparts.service.ShippingZoneService;

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
@WebServlet(urlPatterns = {"/listZone", "/insertZone", "/updateZone", "/deleteZone"})
public class ShippingZoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShippingZoneService szoneDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShippingZoneServlet() {
		this.szoneDAO = new ShippingZoneService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath()); 

		String action = request.getServletPath();

		System.out.println(action);

		switch(action) {
		case "/insertZone":
			try {
				insertShippingZone(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/updateZone":
			try {
				updateShippingZone(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/deleteZone":
			try {
				deleteShippingZone(request, response);
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			break;

		case "/findZone":
			try {
				selectShippingZone(request, response);
			} catch (SQLException | IOException | ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "/listZone" :
			try {
				listShippingZone(request, response);
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
	private void insertShippingZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		String name = request.getParameter("name");
		double area = Double.parseDouble(request.getParameter("area"));
		double budget = Double.parseDouble(request.getParameter("budget"));

		ShippingZone szone = new ShippingZone(name, area, budget);

		szoneDAO.insertShippingZone(szone);

		response.sendRedirect("listZone");
	}

	// update shipping zone
	private void updateShippingZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int zid = Integer.parseInt(request.getParameter("zid"));
		String name = request.getParameter("name");
		double area = Double.parseDouble(request.getParameter("area"));
		double budget = Double.parseDouble(request.getParameter("budget"));

		ShippingZone szone = new ShippingZone(zid, name, area, budget);

		szoneDAO.updateShippingZone(szone);

		response.sendRedirect("listZone");
	}

	// delete shipping zone
	private void deleteShippingZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int zid = Integer.parseInt(request.getParameter("zid"));
		szoneDAO.deleteShippingZone(zid);

		response.sendRedirect("listZone");
	}

	// list shipping zone
	private void listShippingZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		List<ShippingZone> zoneList = szoneDAO.selectallShippingZones();

		request.setAttribute("zoneList", zoneList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/shipping_zone.jsp");

		dispatcher.forward(request, response);
	}

	// find shipping zone
	private void selectShippingZone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int zid = Integer.parseInt(request.getParameter("zid"));

		ShippingZone zone = new ShippingZone(szoneDAO.selectShippingZone(zid));

		request.setAttribute("zone", zone);

		response.sendRedirect("listZone");
	}
}
