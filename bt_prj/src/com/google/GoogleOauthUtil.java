package com.google;

import java.util.HashMap;

public class GoogleOauthUtil {

	String CLIENT_ID = "132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com";
	String CLIENT_SECRET = "XQqw1OT08XMBnv6wUkzYT5ct";
	String REDIRECT_URI = "http://localhost:8088/google_redirect";

	
	
	/**
	 * 구글 로그인을 위한 인증 오픈창 주소 생성
	 * @return
	 */
	//https://accounts.google.com/o/oauth2/v2/auth?
	//client_id=132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com
	//&response_type=code&scope=profile%20email&redirect_uri=http://localhost:8080/google_redirect
	//&state=542E2073FB54EDE4B344968B5D9CCBFC&access_type=offline&approval_prompt=force
	public String getGoogleOauthUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("https://accounts.google.com/o/oauth2/v2/auth?")
	          .append("scope=profile%20email") 
	          .append("&access_type=offline") 
	          //.append("&state=").append(request.getSession().getId())
	          .append("&redirect_uri=").append(REDIRECT_URI) 
	          .append("&response_type=code")
	          .append("&client_id=").append(CLIENT_ID) 
	          .append("&approval_prompt=force"); // this requires them to verify which account to use, if they are already signed in
        return builder.toString();
    }
	
	
	
	/**
	 * code를 사용해 access_token 받아오기
	 * @param code
	 */
	/* 
		response access_token by code : https://accounts.google.com/o/oauth2/token
		{
		access_token=ya29.GmBuBpj1c9qqhPwNDk3ovdW-to0zM68-wjqwd6vHrCbwZbhQa5g-wo9_4JbJWZf-dQrOQmuTSxUdMEFnGRpyFIoU3_f8f-g5Sz9pjBZIxrc-R7dQJCJZj-4KsuUq56yjUEo
		,scope=https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email
		,id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjBiMDFhOTU4YjY4MGI2MzhmMDU2YzE3ZWQ4NzQ4YmY0YzBiNmQzZTIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiMTMyMTUzMTQwNTIyLTlrbmNyZGhodWFvMGlrN2ZrMzdpM3IxZW44YzMwcWxlLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiMTMyMTUzMTQwNTIyLTlrbmNyZGhodWFvMGlrN2ZrMzdpM3IxZW44YzMwcWxlLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTE2NzgyOTU2ODM1MDE0OTM2NjE2IiwiZW1haWwiOiJjb21zLmtvcmVhQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhdF9oYXNoIjoiN3JIWVJQTElqRHlYVzIwMTYzRkpLQSIsImlhdCI6MTU0NDQxMDUzNywiZXhwIjoxNTQ0NDE0MTM3fQ.FSn31_GginL7WtaZzRnibD4Kxp0nCkTzT0pH8r0bAqIVrWZ86H7h6F_vVEEnktvurQ-haMX8rvZODUfsHbx6jMuWrRbZfxA2GxDhXOlkOKPNZIX4R75fggoLEpriGBZNUC3-DJwRTYpgmrJnCjWTWaQ_MhexsUqkbFS735SsAGoZpZsWEBBdG6jYvyJIeKbPY7ygVaECIUZcYEQlHFrVP_v8caQ5XvblrAUt6SKAxU8sPIOuCLm1trAVUKzh1vV0kx61V8OgWaTY8Tg85THH2RJUfftyp8kPcwvw2q9RPUrCM5lm0YGTHxdwZvY477GbgaeuU9fr9cI9quRMa9Rmtg
		,token_type=Bearer
		,expires_in=3599.0
		//,refresh_token:1/xEoDL4iW3cxlI7yDbSRFYNG01kVKM2C-259HOF2aQbI
		}
	 */
	public HashMap<String, Object> getAccessToken(String code) {
		RequestUtil requestUtil = new RequestUtil();
		HashMap<String, Object> paramMap = new HashMap<String, Object>(); 
		paramMap.put("code", code);		
		paramMap.put("client_id", CLIENT_ID);
		paramMap.put("client_secret", CLIENT_SECRET);
		paramMap.put("redirect_uri", REDIRECT_URI);
		paramMap.put("grant_type", "authorization_code");
		paramMap.put("access_type", "offline");
		paramMap.put("include_granted_scopes", "true");
		HashMap<String, Object> repAccessTokenMap =  requestUtil.sendPostReturnMap("https://accounts.google.com/o/oauth2/token", paramMap);
//		String access_token = (String) repAccessTokenMap.get("access_token");
//		String id_token = (String) repAccessTokenMap.get("id_token");
		return repAccessTokenMap;		
	}
	
	
	
	/**
	 * access_token을 사용해 사용자  profile 정보 가져오기
	 * @param access_token
	 * @return
	 */
	/*
	response userinfo profile  : https://www.googleapis.com/oauth2/v1/userinfo?access_token=
	{  
	"id": "116782956835014936616"
	,  "email": "coms.korea@gmail.com"
	,  "verified_email": true
	,  "name": "kh lee"
	,  "given_name": "kh"
	,  "family_name": "lee"
	,  "link": "https://plus.google.com/116782956835014936616"
	,  "picture": "https://lh4.googleusercontent.com/-GB2S5vRQLvQ/AAAAAAAAAAI/AAAAAAAAAAA/AGDgw-hfHNjWf0TxadN2Z0LTZGOtuu5-Hw/mo/photo.jpg"
	,  "gender": "female"
	,  "locale": "ko"
	}
	*/
	public HashMap<String, Object>  getProfile(String access_token) {
		RequestUtil rutil = new RequestUtil();
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> profileMap = rutil.sendGetReturnMap("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+access_token);
		System.out.println(profileMap);
		return profileMap;
	
		/*
		response tokeninfo  : https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=
		{  "iss": "accounts.google.com"
		,  "azp": "132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com"
		,  "aud": "132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com"
		,  "sub": "116782956835014936616"
		,  "email": "coms.korea@gmail.com"
		,  "email_verified": "true"
		,  "at_hash": "zdyLUJk-L9rDJMX5yYFp3Q"
		X ,"name": "kh lee"  
		X ,"picture": "https://lh4.googleusercontent.com/-GB2S5vRQLvQ/AAAAAAAAAAI/AAAAAAAAAAA/AGDgw-hfHNjWf0TxadN2Z0LTZGOtuu5-Hw/s96-c/photo.jpg"  
		X ,"given_name": "kh"
		X ,"family_name": "lee"  
		X ,"locale": "ko"
		,  "iat": "1544411306"
		,  "exp": "1544414906"
		,  "alg": "RS256"
		,  "kid": "0b01a958b680b638f056c17ed8748bf4c0b6d3e2"
		,  "typ": "JWT"}
		}
		*/
	}
	
	
	
	//request refresh_token 
//	paramMap.put("client_id", CLIENT_ID);
//	paramMap.put("client_secret", CLIENT_SECRET);
//	paramMap.put("redirect_uri", REDIRECT_URI);
//	paramMap.put("grant_type", "refresh_token");
//	String reqRefreshTokenURI = requestPost("www.googleapis.com/oauth2/v4/token", paramMap);
//	Map<String,Object> reqRefreshTokenMap = new HashMap<>();
//	reqRefreshTokenMap = gson.fromJson(res, reqRefreshTokenMap.getClass());
//	String refresh_token = reqRefreshTokenMap.get("fresh_token").toString();
//	System.out.println(refresh_token);	
	
	
//	PrintWriter out = response.getWriter();
//	out.println("code:" + code);
//	out.println("access_token:" + access_token);
////	out.println("refresh_token:" + refresh_token);
//	out.println("email:" + email);
			
			
	
//	-------------------------- get calendar -----------------------------------------------------
//	https://accounts.google.com/o/oauth2/v2/auth?
//		 scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.metadata.readonly&
//		 access_type=offline&
//		 include_granted_scopes=true&
//		 state=state_parameter_passthrough_value&
//		 redirect_uri=http%3A%2F%2Foauth2.example.com%2Fcallback&
//		 response_type=code&
//		 client_id=client_id
//	paramMap.put("scope", "https://www.googleapis.com/auth/calendar.readonly");		//calendar readonly
//	HashMap<String, Object> reppRrofileMap = util.requestGetResponseMap("https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token="+access_token);
//	System.out.println(reppRrofileMap);
	
	

	//<요청:구글인증창/o/oauth2/v2/auth?>
	//response_type=token:::scope,state,redirect_uri=http://localhost:8088/google_redirect, &client_id		
	//https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.metadata.readonly&include_granted_scopes=true&state=state_parameter_passthrough_value&redirect_uri=http://localhost:8088/google_redirect&response_type=token&client_id=132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com
	//-------------------------------
	//<결과:구글인증창/o/oauth2/v2/auth?> -- access_token
	//구글 인증창:&flowName=GeneralOAuthFlow		
	//https://accounts.google.com/signin/oauth/oauthchooseaccount?client_id=132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com&as=rEkZkFqLZEABqx-GdKLX8Q&nosignup=1&destination=http%3A%2F%2Flocalhost%3A8088&approval_state=!ChRnNU5SVzdsTVAzQTQ0THJhUEczahIfMDVHbUVCeTVFVjBaNEJxcmlYbTVkb2tpekJxaWNSWQ%E2%88%99APNbktkAAAAAW-9umU6F7JWn6Kti4P2sLJ484rv-LGsK&xsrfsig=AHgIfE_2iMcOY4pV52vRTPYAAgm5N8Ypqw&flowName=GeneralOAuthFlow
	//구글 인증창 로그아웃
	//https://accounts.google.com/signout/chrome/landing?continue=https://console.cloud.google.com/?_ga%3D2.94551711.-2075615034.1540268075%26pli%3D1&oc=https://console.cloud.google.com/?_ga%3D2.94551711.-2075615034.1540268075%26pli%3D1&hl=ko

	//<요청code>
	//response_type=code         ,access_type=offline:::scope,(include_granted_scopes),state,client_id
	//https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.metadata.readonly&state=state_parameter_passthrough_value&redirect_uri=http%3a%2f%2flocalhost%3a8088%2fgoogle_redirect&response_type=code&access_type=offline&include_granted_scopes=true&client_id=132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com
	//<결과code>
	//http://localhost:8088/google_redirect?state=state_parameter_passthrough_value&code=4/lwAorCwzylg1Zf1PaPmxv8kzoNt_U0EsQlycUA7pZl8I39xIBvukdRW_FbriQc3oFbT-FDjs5nrRk263tKXOqT0&scope=openid+email+profile+https://www.googleapis.com/auth/userinfo.profile+https://www.googleapis.com/auth/plus.me+https://www.googleapis.com/auth/calendar.readonly+https://www.googleapis.com/auth/calendar+https://www.googleapis.com/auth/userinfo.email+https://www.googleapis.com/auth/drive.metadata.readonly+https://www.googleapis.com/auth/gmail.readonly


	////<요청token>
	//response_type:token
	//https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fdrive.metadata.readonly&include_granted_scopes=true&state=state_parameter_passthrough_value&redirect_uri=http://localhost:8088/google_redirect&response_type=token&client_id=132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com
	//<결과token>
	//http://localhost:8088/google_redirect#state=state_parameter_passthrough_value&access_token=ya29.GltWBrGWPcP1dBPGN6LnWqLv_2ymJoXSzI_ZoOExxtXCVJ2zU2Z9tyQQEY2WyHKMicCJiq7zbGnHCN3HwLK_cXH-Tw9Kk7kdtB0kCdmFuJkSrf99UiXeh2xtVaix&token_type=Bearer&expires_in=3600&scope=openid%20email%20profile%20https://www.googleapis.com/auth/plus.me%20https://www.googleapis.com/auth/calendar%20https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/calendar.readonly%20https://www.googleapis.com/auth/drive.metadata.readonly%20https://www.googleapis.com/auth/userinfo.email%20https://www.googleapis.com/auth/gmail.readonly
	
	
	
	
	
}
