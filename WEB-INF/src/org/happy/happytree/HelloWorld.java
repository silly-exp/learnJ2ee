package org.happy.happytree;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import java.io.IOException;


public class HelloWorld extends HttpServlet{

	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	               throws ServletException, IOException{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<h1>Hello World using HttpServlet class.</h1>");
		out.close();
	}
}
