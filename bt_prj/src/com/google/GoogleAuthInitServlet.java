package com.google;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/google_auth_init")
public class GoogleAuthInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//구글 로그인을 위한 인증 오픈창 주소 생성
		GoogleOauthUtil outil = new GoogleOauthUtil();
		String oauthURL = outil.getGoogleOauthUrl();
		System.out.println("oauthURL:"+oauthURL);
		
		PrintWriter out = response.getWriter();
		out.println(oauthURL);
		
		
		//request.setAttribute("authURL", url);
		//request.getRequestDispatcher("google/google_oauth.jsp").forward(request, response);
		
	}
	
	
	
}
