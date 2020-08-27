package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Success
 */
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Success() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		pw.write("<p>You are logged in</p>");
		if(request.getSession(false)==null) {
			System.out.println("You've logged out");
			response.sendError(418,"You are not logged in");
		} else {
			//response.sendRedirect("http://localhost:8080/SignInMaven/Success.html");
			//PrintWriter pw = response.getWriter();
			
			pw.write("<form action=\"/SignInMaven/Success\" method=\"post\">\r\n" + 
					"		<button type=\"submit\" >Logout</button>\r\n" + 
					"	</form>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println("You've logged out");
		request.getSession().invalidate();
		//PrintWriter pw = response.getWriter();
		//pw.write("<p>You have logged out</p>");
		request.getRequestDispatcher("/Logout").forward(request, response);
		//doGet(request,response);
		//response.sendRedirect("http://localhost:8080/SignInMaven/Logout.html");
		
		
	}

}
