package com.safvan.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecuredServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<h1> This is a secured servlet </h1>");
		out.println("<h1> Only authenticated peoples can access </h1>");
			
		String authType = request.getAuthType();
		String remoteUser = request.getRemoteUser();
		
		out.println("<h1> Authetication type: "+authType+"</h1>");
		out.println("<h1> Autheticated user: "+remoteUser+"</h1>");
		
		out.close();
	}
}
