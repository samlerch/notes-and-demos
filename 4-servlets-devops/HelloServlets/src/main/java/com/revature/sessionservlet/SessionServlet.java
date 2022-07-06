package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class SessionServlet extends HttpServlet {

	/*
	 * When we send a GET request to this servlet (at /sesserv url) we will generate
	 * a Villain Object and send it to the session
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Let's Hard code a villain object
		SuperVillain mudman = new SuperVillain("Mud Man", "Mud Armor", 400);

		// Let's capture the HttpSession from the request object
		HttpSession session = request.getSession();

		// Save the villain object to the session
		session.setAttribute("the-villain", mudman);

		System.out.println(session.getId());

		// Let's use the printWriter object from the response to print out some message
		// to the browser
		// about what happened
		PrintWriter out = response.getWriter();

		// Write it out in JSON format
		out.write(new ObjectMapper().writeValueAsString(mudman));
		out.println("Mud man is on the loose and the session is set");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * The purpose of this method is to capture the parameter from the HTTP request that is
		 * sent to the /seserv url, the instantiate an object from them and add it to the session
		 */
		
		// 1. Capture input from http request
		String name = request.getParameter("name"); // this must match the name of the input field in the index.html
		String superPower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty")); // Convert a string to a double by parsing
		
		// 2, Instantiate an object with this info
		SuperVillain vill = new SuperVillain(name, superPower, bounty);
		
		//3. Capture the HTTP Session from the request
		HttpSession session = request.getSession();
		
		//4. Send the custom villain object to the session
		session.setAttribute("the-villain", vill);
		
		//5. Print to the screen (using print writer) that the villain object was successfully
		// sent to the session
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(vill));
		out.println("A villain is on the loose... (in the session)");
		
		// After it's been sent to the session we can retrieve it by doing a get request
		// on the helperSessionServlet
 	}

}
