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

	/*
	 * This method is going to be responsible for handling a POST request that the client sends. We'll
	 * instantiate an object, and send back the object's data in the form of a JSON for data interchange
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Step 1: Declare the type of our HTTP response
		response.setContentType("application/json");
		
		// Step 2: Instantiate the object
		SuperVillain vill = new SuperVillain("The Penguin", "money", 900.10);
		
		// Now we need to marshall or transform the object into JSON format and send it to the browser in body of an
		// HTTP response
		// Here we're going to transform it AND send it using the PrintWriter
		response.getWriter().write(new ObjectMapper().writeValueAsString(vill));
		
	}
	
	
	
	
}
