package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getSession(false)!=null) {
			request.getRequestDispatcher("/Success").forward(request, response);
		} else {
			response.sendRedirect("http://localhost:8080/SignInMaven/Login.html");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			if(request.getParameter("username").equals("test")&&request.getParameter("password").equals("password")) {
				HttpSession session = request.getSession(); //Either return the current session or create a new session.
				session.setAttribute("username", request.getParameter("username"));
				session.setAttribute("password", request.getParameter("password"));
				response.sendRedirect("http://localhost:8080/SignInMaven/Success");
				
			} else {
				request.getRequestDispatcher("/FailedLogin.html").forward(request, response);
			}
		} catch (Exception e) {
			request.getRequestDispatcher("/FailedLogin.html").forward(request, response);
		}
		
		
		
//		request.getRequestDispatcher("/SuperSecureServlet").forward(request, response);
		
	}

}
