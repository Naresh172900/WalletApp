package com.example.wallet.configs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class Configclass extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	
//	  @Override protected void configure(HttpSecurity httpSecurity) throws
//	  Exception {
//	  httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
//	  .authorizeRequests().anyRequest().authenticated().antMatchers(
//	  "/h2-console/**").permitAll(); httpSecurity.csrf().disable();
//	  httpSecurity.headers().frameOptions().disable(); }
	 
	@Bean
   public AuthenticationProvider authProvider() {
	  DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
	 
	provider.setUserDetailsService(userDetailsService);
	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	return provider;
	   
   }

  
	

}
