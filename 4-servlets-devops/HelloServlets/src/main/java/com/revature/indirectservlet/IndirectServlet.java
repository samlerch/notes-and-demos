package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndirectServlet extends HttpServlet{
	
	//There are two main ways of redirecting a user to another servlet. These two methods are forward() and sendRedirect()

	// If a GET request is sent here we'll re-direct to the DirectServlet
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirect the user to some other resource
		
//		response.sendRedirect("http://localhost:8080/HelloServlets/dirserv");
		response.sendRedirect("https://google.com");
		
		System.out.println("triggered the doGet() method of IndirectServ");
	}

	// The purpose of this method is to showcase the forward() method
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Forward() which is fetch from the requestdispatcher which further processes the original request
		// rather than generating a new one
		
		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		
		// This is where you would further process the request if need be
		
		// Let's forward the request
		rdis.forward(request, response);
		
		System.out.println("doPost() method triggered");
	}
	
	/*
	 * Here is a list of major differences between servlet forward and
	 * sendRedirect()
	 * 
	 * sendRedirect():
	 * 
	 * The request is redirected to a different resource The client will see the URL
	 * change after the redirect A totally new request is created Redirect is
	 * normally used within Post/Redirect/Get web development pattern
	 *
	 * 
	 * forward():
	 * 
	 * The request will be further processed on the server side The client isn't
	 * impacted by forward, URL in a browser stays the same Request and response
	 * objects will remain the same object after forwarding. Request-scope objects
	 * will be still available
	 */
	
	

}
