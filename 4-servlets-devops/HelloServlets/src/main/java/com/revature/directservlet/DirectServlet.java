package com.revature.directservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

// Extends the HttpServlet class to add in our http specific methods
public class DirectServlet extends HttpServlet{
	
	/*
	 * When a client sends a get request to the server at some location( which we have yet to map, this will be done
	 * in our web.xml file) it will then trigger this method
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Here we can deliver a response to our get methods
		// We'll send back some raw html in this case to show the server is talking directly to the client
		
		// Set the content type of our return header to html
		response.setContentType("text/html");
		
		/*
		 * Printwriter is an object that prints text data to a character stream which we call on the response objects
		 */
		
		PrintWriter out =response.getWriter();
		
		out.println("<html><body><h1> The server is talking directly to the client </h1></body></html>");
		
		// Now that we have a method to handle our get request we can map this functionality
	}
	
	/**
	 * This method is responsible for handling a POST request that a client sends.
	 * Instantiate an object, and send back the object's data in the form of JSON - JavaScript Object Notation
	 * JSON = a data interchange format
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Step 1. Declare the type of content for our HTTP response
		response.setContentType("application/json");

		// Step 2. Instantiate an object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 900.10);

		// transform a java object into JSON and send it to the browser (client) in the body of the HTTP response
		// Here we're both transforming is AND sending it via the print writer on the response
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		// import ObjectMapper from Jackson Databind
	}

	/**
	 * HTTP Response
	 * 
	 * Response Header
	 * 	- HTTP Version
	 * 	- Status code
	 * 
	 * Response Body (contains the data its sending back!)
	 */
}
