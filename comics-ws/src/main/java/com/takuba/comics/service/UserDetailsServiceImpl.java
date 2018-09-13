package com.takuba.comics.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.takuba.comics.dao.model.User;
import com.takuba.comics.dao.model.UserRole;
import com.takuba.comics.dao.repository.UserRepository;
import com.takuba.comics.dao.repository.UserRolesRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRolesRepository userRolesRepository;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		if(user == null){
			  throw new UsernameNotFoundException("El usuario:" + userName + " no existe en la base de datos");
		}
		List<UserRole> listRoles= userRolesRepository.findByUsername(userName);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if(listRoles!=null){
			for(UserRole role: listRoles){
				GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(userName, user.getPassword(), grantList);
		return userDetails;
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public UserRolesRepository getUserRolesRepository() {
		return userRolesRepository;
	}
	public void setUserRolesRepository(UserRolesRepository userRolesRepository) {
		this.userRolesRepository = userRolesRepository;
	}

}
