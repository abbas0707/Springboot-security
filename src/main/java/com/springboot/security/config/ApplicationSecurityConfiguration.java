package com.springboot.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

import com.springboot.security.handler.FailedLoginHandler;
import com.springboot.security.handler.MyCustomAccessDeniedHandler;
import com.springboot.security.handler.MyCustomAuthenticationEntryPoint;
import com.springboot.security.handler.SuccessfullLogoutHandler;
import com.springboot.security.handler.SuccessfulloginHandler;

@Component
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Autowired
	  private SuccessfulloginHandler loginSuccessfulHandler;
	  @Autowired
	  private FailedLoginHandler loginFailureHandler;
	  @Autowired
	  private SuccessfullLogoutHandler logoutSuccssfulHandler;
	  @Autowired
	  private MyCustomAccessDeniedHandler accessDeniedHandler;
	  @Autowired
	  private MyCustomAuthenticationEntryPoint authEntryPoint;
	  
	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()) 
		  .withUser("user").password("123").roles("USER")
		  .and()
		  .withUser("admin").password("admin").roles("ADMIN");
		  
		  
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  
		 http.csrf().disable()
		  .formLogin().loginProcessingUrl("/auth/login")
		  .successHandler(loginSuccessfulHandler)
		  .failureHandler(loginFailureHandler)		  
		  .and()
          .logout()
          .logoutUrl("/auth/logout")
          .logoutSuccessHandler(logoutSuccssfulHandler)
		 .and()
		  .authorizeRequests()
		  .antMatchers("/auth/login").permitAll()		 
		 /* .antMatchers("/secure/anony").permitAll()	  */
		  .antMatchers("/secure/user").hasRole("USER")
		  .antMatchers("/secure/admin").hasRole("ADMIN")		  
		  
		  .anyRequest()
		  .authenticated()
		  .and()
		  .exceptionHandling()
		  .accessDeniedHandler(accessDeniedHandler)
		 .authenticationEntryPoint(authEntryPoint)
		  .and()
		  .anonymous()
		  .disable() ;
		  
		
		  
		  
	  }
}
