package com.examserver.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.repository.RoleRepository;
import com.examserver.repository.UserRepository;
import com.examserver.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local != null) {
			throw new Exception("User already present!!");
		}else {
			
			//user create
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local =  this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUserByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUserById(Long id) {
		this.userRepository.deleteById(id);
		
	}

	@Override
	public List<User> getUserList() {
		return this.userRepository.findAll();
	}

}
