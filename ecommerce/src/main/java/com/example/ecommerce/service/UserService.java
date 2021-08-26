package com.example.ecommerce.service;

import java.util.List;

import com.example.ecommerce.model.User;

public interface UserService {
	List<User> getAll();

	void createUser(User user);

	User deleteUser(long id);
}
