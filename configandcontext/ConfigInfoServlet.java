package com.marlabs.configandcontext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigInfoServlet
 */
public class ConfigInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigInfoServlet() {
		super();
		System.out.println("ConfigInfoServlet Constructor");
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
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		printWriter.println("<html><body>");

		printWriter.println("<p>*************Request Body Content***************</p>");
		//
		// Conplete for Congif Header Paramenter;
		//
		printWriter.println("<p>************************************************</p>");

		printWriter.println("<p>*************Request Body Content***************</p>");
		printWriter.println("<p>User Name:</p>" + userName);
		printWriter.println("<p>User Password: </p>" + userPassword);
		printWriter.println("<p>*************************************************</p>");
		printWriter.println("<p>*************Servlet Config Content***************</p>");
		ServletConfig config = getServletConfig();
		double HRA = Double.parseDouble(config.getInitParameter("HRA"));
		double Basic = Double.parseDouble(config.getInitParameter("Basic"));
		double DA = Double.parseDouble(config.getInitParameter("DA"));
		printWriter.println("<p>HRA: " + HRA + "</p>");
		printWriter.println("<p>Basic: " + Basic + "</p>");
		printWriter.println("<p>DA: " + DA + "</p>");

		printWriter.println("<p>*************************************************</p>");
		printWriter.println("<p>*********************Serlvlet Context******************</p>");

		ServletContext servletContext = config.getServletContext();
		printWriter.println("Servlet Logical Name: " + servletContext);
		Enumeration<String> servletContextParamenterName = servletContext.getAttributeNames();
		while (servletContextParamenterName.hasMoreElements()) {
			String contextParameterName = servletContextParamenterName.nextElement();
			printWriter.println("contextParameterName: " + servletContext.getInitParameter(contextParameterName));

		}
		printWriter.println("<p>*************************************************</p>");
		printWriter.println("<p>***************Servlet Logical Name*****************</p>");
		printWriter.println("Servlet Logical Name: " + config.getServletName());
		printWriter.println("<p>*************************************************</p>");

		printWriter.println("Server Context info");
		printWriter.println("<p>*************************************************</p>");

		Enumeration<String> initParameterNames = config.getInitParameterNames();

		while (initParameterNames.hasMoreElements()) {
			String initPameterName = initParameterNames.nextElement();

			System.out.println(
					"Init para Name: " + initPameterName + " Value: " + config.getInitParameter(initPameterName));

		}

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
