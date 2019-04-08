package com.niit.springjwt.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.niit.springjwt.model.User;

@Repository
public class UserRepository {

	private User findByUserName(String username) {
		Map<String,User>userMap = buildUser();
		User user = userMap.get(username);
		return user;
	}
	
	public static Map<String,User> buildUser() {
		User user = new User();
		user.setId(1);
		user.setName("dinesh");
		user.setPassword("password");
		Map<String,User>usersMap = new HashMap<>();
		usersMap.put(user.getName(), user);
		return usersMap;
	}
}
