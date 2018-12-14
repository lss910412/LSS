package com.biz.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biz.member.MemberDAO;
import com.biz.member.MemberVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/manager")
public class BoardManagerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerDAO mdao = new ManagerDAO();
		String  code= request.getParameter("code");
		
		
		ManagerVO vo= mdao.selectBoardInfo(code);
		String list_url = vo.getBoard_list_url();
		
		ArrayList<ManagerVO> blist= mdao.boardList(code);
		
		request.setAttribute("KEY_VO", vo);
		request.setAttribute("KEY_LIST", blist);
		request.getRequestDispatcher("board/"+list_url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  code= request.getParameter("code");
		String  btitle= request.getParameter("btitle");
		String  attach_yn= request.getParameter("attach_yn");
		String board_list_url= request.getParameter("board_list_url");
		String  board_insert_url= request.getParameter("board_insert_url");
		String  bgcolor= request.getParameter("bgcolor");
		ManagerVO vo = new ManagerVO();
		vo.setCode(code);
		vo.setBtitle(btitle);
		vo.setAttach_yn(attach_yn);
		vo.setBoard_list_url(board_list_url);
		vo.setBoard_insert_url(board_insert_url);
		vo.setBgcolor(bgcolor);
//		
		ManagerDAO mdao = new ManagerDAO();
		int res = mdao.insert(vo);
		response.sendRedirect("/manager_list");
		
	}

}
