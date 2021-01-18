package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		User.UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("user1").password("pw1").roles("EMPLOYEE"))
				.withUser(users.username("user2").password("pw2").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("user3").password("pw3").roles("MASZER", "EMPLOYEE"));

	}

	/**
	 * Without this overridden method, the Spring-Security standard login-form and
	 * error messages will be used!
	 * 
	 * Just enter context root to get to login page (with or without custom login)
	 * 
	 * 
	 * "antMatchers" ...Configure Spring Security to allow unauthenticated requests
	 * (permit all) to the "/css" directory
	 */
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()
				.antMatchers("/css/**").permitAll()		// for css folder
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")		// url provided by spring
				.permitAll()
			.and().logout().permitAll();				// gives logout support, which provides! default url (/logout)

	}

}
