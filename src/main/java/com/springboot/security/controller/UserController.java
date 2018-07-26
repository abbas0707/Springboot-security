package com.springboot.security.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.entities.AppResponse;

@RestController
@RequestMapping("/secure")
public class UserController {
	
	@GetMapping("/user")
	  public Principal getUser(Principal user) {
			Authentication auth = SecurityContextHolder.getContext()
			                .getAuthentication();
			System.out.println("user: "+ auth.getName());
			System.out.println("roles: "+ auth.getAuthorities());
	    return user;

	
	}
	
	  @GetMapping("/admin")
	  public Principal getAdmin(Principal admin) {
	    return admin;
	  }
	  
	 /* @GetMapping("/anony")
	  public AppResponse testAnony(Principal admin) {
		  
		  AppResponse json = new AppResponse();
		  json.setCode("200");
		  json.setMessage("Annonymous access successfull ");
	    return json;
	  }*/
	  
	 
}
