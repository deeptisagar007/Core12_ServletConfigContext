package com.marlabs.configandcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextInfoServlet
 */
public class ContextInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContextInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html><body>");
		printWriter.println("<p>*****************Request Parameter********************</p>");
		Enumeration<String> requestParaNames = request.getParameterNames();
		while (requestParaNames.hasMoreElements()) {
			printWriter.println("<br>");
			String requestParaName = requestParaNames.nextElement();
			printWriter.println(
					"RequestParaNames: " + requestParaName + " Values: " + request.getParameter(requestParaName));
		}
		printWriter.println("<p>************************************************</p>");
		printWriter.println("<p>***********************Context Parameter Data*************************</p>");

		ServletConfig config = getServletConfig();
		ServletContext contex = config.getServletContext();
		Enumeration<String> contextParamNames = contex.getInitParameterNames();
		while (contextParamNames.hasMoreElements()) {
			String contextParamName = contextParamNames.nextElement();
			printWriter.println("<br>");
			printWriter.println(
					"ContextParamName: " + contextParamName + " Values: " + contex.getInitParameter(contextParamName));
		}

		printWriter.println("<p>************************************************</p>");
		printWriter.println("<p>********************Dynamically Set Attribute********************</p>");
		List<String> list = new LinkedList<String>();
		list.add("Deepti");
		list.add("Deepti2");
		contex.setAttribute("ListAttribute", list);
		printWriter.println("Context Attribute Name: " + contex.getAttribute("ListAttribute"));
		printWriter.println("<p>************************************************</p>");

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
