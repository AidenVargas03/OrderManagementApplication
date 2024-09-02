package com.gcu.ordermanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import com.gcu.ordermanagement.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class OMSecurityConfig extends WsConfigurerAdapter {
	
	@Autowired
	UserBusinessService service;
	

	protected void configure(HttpSecurity http) throws Exception {
		http
        .httpBasic()
            .and()
            .authorizeRequests()
            .requestMatchers("/products/").authenticated()
            .and()
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/", "/home", "/images/", "/products/**").permitAll()
            .anyRequest().authenticated())
        .formLogin(login -> login
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .defaultSuccessUrl("/products/display", true))
         .logout(logout -> logout
            .logoutUrl("/home")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll()
            .logoutSuccessUrl("/"));
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		//String encoded = new BCryptPasswordEncoder().encode("password1");
		//System.out.println(encoded);
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder());
	}

	private PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

}
