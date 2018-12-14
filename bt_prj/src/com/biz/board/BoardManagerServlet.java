package com.biz.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/manager_list")
public class BoardManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDAO mdao = new ManagerDAO();
		ArrayList<ManagerVO> list= mdao.select();
		request.setAttribute("KEY_LIST", list);
		request.getRequestDispatcher("board/main.jsp").forward(request, response);
	}

}
