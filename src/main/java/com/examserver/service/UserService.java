package com.examserver.service;

import java.util.List;
import java.util.Set;


import com.examserver.model.User;
import com.examserver.model.UserRole;

public interface UserService {
	public List<User> getUserList();
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
	public User getUserByUsername(String username);
	public void deleteUserById(Long id);
}
