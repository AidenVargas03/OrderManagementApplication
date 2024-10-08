package com.gcu.ordermanagement.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.UsersDataService;
import com.gcu.ordermanagement.data.entity.UserEntity;

@Service
public class UserBusinessService implements UserDetailsService{
	
	@Autowired
	UsersDataService service;

	public UserBusinessService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = service.findByUsername(username);
		
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("User"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else {
			throw new UsernameNotFoundException("username not foud");
		}
	}

}
