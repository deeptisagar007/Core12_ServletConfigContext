package com.marlabs.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionDemo() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		double userSal = Double.parseDouble(request.getParameter("userSal"));
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));

		HttpSession session = request.getSession(true);
		session.setAttribute("userName", userName);
		session.setAttribute("userId", userId);
		session.setAttribute("userSal", userSal);
		session.setAttribute("deptNo", deptNo);

		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		System.out.println("In servlet");
		printWriter.println("<html><body>");
		printWriter.println("<form method='post' action='./SessionDemo2'> ");
		printWriter.println(" <pre>");
		printWriter.println("User Qualification: <input type='text' name='qualification' /> ");
		printWriter.println("User Designation: <input type='text' name='designation' /> ");
		printWriter.println("<input type='submit' value='Submit' /> ");
		printWriter.println("</pre> </form>");
		printWriter.println(" ");
		printWriter.println(" ");
		printWriter.println(" ");

		printWriter.println("</body></html>");

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
