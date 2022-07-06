package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

public class HelperSessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// When we do the doGet method on this Servlet, it will return the villain object that we have
		// Saved to the session
		
		// 1. Grab the session from the request
		HttpSession session = request.getSession();
		
		// 2. Save the object fetch from the session to a SuperVillain object
		SuperVillain vill = (SuperVillain) session.getAttribute("the-villain");
		// We search for the object that we bound to the session based off the attriubte
		// we set in the sessionServlet's doGet() method
		
		// 3. After "capturing" the villain from the session print it out via the printwiter
		
		PrintWriter out = response.getWriter();
		
		// Now let's make our webpage dynamic by generating a new html page on the fly
		out.println("<html><body>");
		
		if(vill != null) {
			out.println("We have captured the villain from the session");
		// Print out the html with all of the properties of the villain we captured
		out.println("<h1> Villain Name: " + vill.getName() + " </h1><br />");
		out.println("<b>SuperPower: " + vill.getSuperPower() + "</b><br />");
		out.println("<i> Bounty: $" + vill.getBounty() + "</i><br />");
		} else {
			out.println("<i> Couldn't find any Villains");
		}
		
		
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
