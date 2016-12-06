package com.niit.loginapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.loginapp.DAO.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALLING DOGET METHOD");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//read username and password
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALLING DOPOST METHOD");
		//doGet(request, response);
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		UserDAO userDAO = new UserDAO(); 
		RequestDispatcher dispatcher;
		
		if(userDAO.isValidUser(userName, password)){
			dispatcher = request.getRequestDispatcher("Home.jsp");
			dispatcher.forward(request, response);
		}else{
			dispatcher = request.getRequestDispatcher("Login.jsp");
			PrintWriter writer = response.getWriter();
			writer.println("PLZ LOGIN AGAIN!");
			dispatcher.include(request, response);
		}
		//System.out.println("USERNAME : "+username);
		//System.out.println("PASSWORD : "+password);
		
		//if(username.equals("pavan") && password.equals("pavan")){
			//System.out.println("SUCESS");
		//}else{
			//System.out.println("FAILED");
		//}
	}

}
