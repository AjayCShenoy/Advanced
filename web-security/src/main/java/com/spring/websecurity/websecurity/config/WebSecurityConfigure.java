package com.spring.websecurity.websecurity.config;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(new DaoAuthenticationProvider());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	http.authorizeRequests().antMatchers("\"/api/v1/issue-book\"").permitAll().anyRequest().authenticated()
	.and().exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
	}

    
    
 
  
}
