<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
</head>
<body>
	<h1>Welcome UserProfile</h1>
	<%
		Enumeration attributeNames = session.getAttributeNames();
		while(attributeNames.hasMoreElements()){
			String attributeName = attributeNames.nextElement().toString();
			String attribute = session.getAttribute(attributeName).toString();
			out.println("Name: "+attributeName+" value: "+attribute);
			out.println("<br />");
		}
	%>
</body>
</html>