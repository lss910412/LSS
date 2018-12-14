package com.google;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

//access_token	: The token that your application sends to authorize a Google API request.
//refresh_token	: A token that you can use to obtain a new access token. Refresh tokens are valid until the user revokes access. Again, this field is only present in this response if you set the access_type parameter to offline in the initial request to Google's authorization server.
//expires_in	: The remaining lifetime of the access token in seconds.
//token_type	: "Bearer"

@WebServlet("/google_redirect")
public class GoogleRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get call");

		GoogleOauthUtil outil = new GoogleOauthUtil();
		
		//-------------------- code를 사용해 access_token 받아오기 ------------------
		String code = request.getParameter("code");
		HashMap<String, Object>  accessTokenMap = outil.getAccessToken(code);

		//-------------------------- get profile -----------------------------
		String accessToken = accessTokenMap.get("access_token").toString();
		HashMap<String, Object> profileMap = outil.getProfile(accessToken);
		
		HttpSession session = request.getSession();
		session.setAttribute("SESS_TOKEN", accessToken);
		session.setAttribute("SESS_EMAIL", 	profileMap.get("email").toString());
		session.setAttribute("SESS_NAME", profileMap.get("name").toString());
		session.setAttribute("SESS_PIC", profileMap.get("picture").toString());
		response.sendRedirect("google/user_main.jsp");
		
	
	}	



	
	
	
	

}
