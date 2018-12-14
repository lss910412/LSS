package com.biz.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Step1
 */
@WebServlet("/step1")
public class Step1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		System.out.println("step1 get");
		response.sendRedirect("/step2");
		//request.getRequestDispatcher("/step2").forward(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		System.out.println("step1 post");
		response.sendRedirect("/step2");
		//request.getRequestDispatcher("/step2").forward(request,response);
		
	}

	

}
