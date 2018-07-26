package com.springboot.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessfulloginHandler implements AuthenticationSuccessHandler {

	/*@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Inside succssfull login handler ... ");
		response.setStatus(HttpStatus.OK.value());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();
		json.put("message", "Login Successfull");
		response.getWriter().write(json.toString());

	}*/
	
	 @Override
	  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	      throws IOException, ServletException {

	    response.setStatus(HttpStatus.OK.value());
	    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    JSONObject jsonResponse = new JSONObject();
	    jsonResponse.put("message", "Login Successful");
	    response.getWriter().write(jsonResponse.toString());
	  }


}
