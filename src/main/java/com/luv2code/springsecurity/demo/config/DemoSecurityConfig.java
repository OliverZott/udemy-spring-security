package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * No need to hardcode users; Spring knows about db tables (cause set in config)
		 * and we use the standard table-schema
		 */
		auth.jdbcAuthentication().dataSource(securityDataSource);

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
				.antMatchers("/css/**").permitAll()        // for css folder
				.antMatchers("/").hasRole("EMPLOYEE")
				.antMatchers("/leaders/**").hasRole("MANAGER")
				.antMatchers("/systems/**").hasRole("ADMIN")
				.and()
				.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")        // url provided by spring
				.permitAll()
				.and().logout().permitAll()            // gives logout support, which provides! default url (/logout)
				.and().exceptionHandling().accessDeniedPage("/access-denied");

	}

}
