package com.example.spring.security.jwt.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	
	
	
	public MyUserDetails(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.active = user.isActive();
		this.authorities = Arrays.asList(user.getRoles().split(","))
							.stream()
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
	}




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}




	@Override
	public String getPassword() {
		return password;
	}




	@Override
	public String getUsername() {
		return username;
	}




	@Override
	public boolean isAccountNonExpired() {
		return active;
	}




	@Override
	public boolean isAccountNonLocked() {
		return active;
	}




	@Override
	public boolean isCredentialsNonExpired() {
		return active;
	}




	@Override
	public boolean isEnabled() {
		return active;
	}

	

}
