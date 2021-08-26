package com.example.ecommerce.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User deleteUser(long id) {
		User user = userRepository.getById(id);
		userRepository.deleteById(id);
		return user;
	}

}
