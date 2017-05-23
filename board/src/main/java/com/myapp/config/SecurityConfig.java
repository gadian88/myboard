package com.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.myapp.member.controller.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired UserService userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
         http
              .csrf().disable()
              .authorizeRequests()
                   .anyRequest().authenticated()
                   .and()
              .formLogin();
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(userService)
         .passwordEncoder(userService.passwordEncoder())
         ;
    }
}