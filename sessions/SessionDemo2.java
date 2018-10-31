package com.marlabs.sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo2
 */
public class SessionDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionDemo2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		String qualification = request.getParameter("qualification");
		String designation = request.getParameter("designation");
		session.setAttribute("qualification", qualification);
		session.setAttribute("designation", designation);

		Enumeration<String> sessionNames = session.getAttributeNames();
		while (sessionNames.hasMoreElements()) {
			String sessionName = sessionNames.nextElement();
			String sessionData = session.getAttribute(sessionName).toString();
			System.out.println("Session Data: " + sessionData);
		}

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		response.sendRedirect("./userProfile.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
