package com.examserver.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.Role;
import com.examserver.model.User;
import com.examserver.model.UserRole;
import com.examserver.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping
	public List<User> getUserList(){
		return this.userService.getUserList();
	}
	
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) throws Exception {
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role(45L,"NORMAL");
		
		//encode password with bcryptpasswordencoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		UserRole userRole = new UserRole();
		
		userRole.setRole(role);
		userRole.setUser(user);
		
		roles.add(userRole);
		
		
		return this.userService.createUser(user, roles);
	}
	
	//get user by username
	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return this.userService.getUserByUsername(username);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		this.userService.deleteUserById(id);
	}
}
