package com.jimbrighter.security;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class PhotodumpSecurity extends WebSecurityConfigurerAdapter {

	@Inject
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			csrf().disable()
			.authorizeRequests()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/status").permitAll()
			.antMatchers("/dashboard").authenticated()
			.antMatchers("/admin/**").authenticated()
			.antMatchers("/**").authenticated()
			.and()
			.formLogin().defaultSuccessUrl("/dashboard.html")
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
	}
}
