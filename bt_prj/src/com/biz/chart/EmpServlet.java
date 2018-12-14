package com.biz.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		ArrayList<EmpVO> list = t.empList();
		request.setAttribute("KEY_LIST", list);
		request.getRequestDispatcher("style_test.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ch99JDBCImpl t = new Ch99JDBCImpl();
		Gson gson = new Gson();
		
		/*
		//---------------------------------------------
		//1-1.String으로 들어와서 String으로 보내는 경우
		//searchColumn=deptno&searchStr=10
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
		String searchColumn = request.getParameter("searchColumn");	//전달된  String데이터
		String searchStr = request.getParameter("searchStr");		//전달된  String데이터
		ArrayList<EmpVO> list = t.empList(searchColumn, searchStr);
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);

		PrintWriter out = response.getWriter(); 					//응답 데이터 타입:String
		out.println(gsonStr);*/
		
		
		//---------------------------------------------
		//1-2.StringJson으로 들어와서 String으로 보내는 경우
		//MYKEY="{"searchColumn":"deptno", "searchStr":"10"}"
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
		String strJson = request.getParameter("MYKEY");	//전달된  String데이터{json표기유형}
		System.out.println(strJson);
		
		SearchVO svo = gson.fromJson(strJson, SearchVO.class);
		ArrayList<EmpVO> list = t.empList(svo.getSearchColumn(), svo.getSearchStr());
		String gsonStr = gson.toJson(list);						//String변환
		System.out.println(gsonStr);  //"[{"empn
		
		PrintWriter out = response.getWriter();					//응답 데이터 타입:String
		out.println(gsonStr); //"[{"empno
		
		
		/*
		//---------------------------------------------
		//2.String으로 들어와서 Json으로 보내는 경우
		//searchColumn=deptno&searchStr=10
		//[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]
		//---------------------------------------------
		String searchColumn = request.getParameter("searchColumn");	//전달된  String데이터
		String searchStr = request.getParameter("searchStr");
		ArrayList<EmpVO> list = t.empList(searchColumn, searchStr);
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);
		
		response.setContentType("application/json; encoding=UTF-8"); //응답 데이터 타입:JSON
		PrintWriter out = response.getWriter();
		out.println(gsonStr);*/
		
		
		/*
		//---------------------------------------------
		//3.Json으로 들어와서 String으로 보내는 경우
		//{"searchColumn":"deptno", "searchStr":"10"}
		//"[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]"
		//---------------------------------------------
		String jsonStr = request.getReader().lines().collect(Collectors.joining());	//전달된  Json데이터
		System.out.println(jsonStr);
		SearchVO svo = gson.fromJson(jsonStr, SearchVO.class);
		
		ArrayList<EmpVO> list = t.empList(svo.getSearchColumn(), svo.getSearchStr());
		String gsonStr = gson.toJson(list);						//String변환
		System.out.println(gsonStr);
		
		PrintWriter out = response.getWriter();					//응답 데이터 타입:String
		out.println(gsonStr);
		*/
		
		/*
		//---------------------------------------------
		//4.Json으로 들어와서 Json으로 보내는 경우
		//{"searchColumn":"deptno", "searchStr":"10"}
		//[
		//	{"empno":6666,"ename":"rrr","mgr":0,"sal":0,"comm":0,"deptno":0},
		//	{"empno":7782,"ename":"CLARK","mgr":0,"sal":0,"comm":0,"deptno":0}
		//]
		//---------------------------------------------
		String jsonStr = request.getReader().lines().collect(Collectors.joining());	//전달된  Json데이터
		System.out.println(jsonStr);
		SearchVO svo = gson.fromJson(jsonStr, SearchVO.class);
		
		ArrayList<EmpVO> list = t.empList(svo.getSearchColumn(), svo.getSearchStr());
		String gsonStr = gson.toJson(list);							//String변환
		System.out.println(gsonStr);
		
		response.setContentType("application/json; encoding=UTF-8"); //응답 데이터 타입:JSON
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
		*/
	}

}
