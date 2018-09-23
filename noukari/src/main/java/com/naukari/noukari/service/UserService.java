package com.naukari.noukari.service;

import org.springframework.stereotype.Service;

import com.naukari.noukari.entity.UserEntity;
import com.naukari.noukari.exception.UserNotFoundException;
import com.naukari.noukari.model.User;
import com.naukari.noukari.repository.UserRepository;

@Service
public class UserService {

	private UserRepository repository;

	public User login(User user) {

		UserEntity entity = repository.findByUserId(user.getUserName());

		if (null != entity) {
			if (user.getUserName().equals(entity.getUserName()) && user.getPassword().equals(entity.getPassword())) {
				user.setUserName(entity.getUserName());
				user.setPassword(null);
				user.setUserName(entity.getUserName());
				user.setRole(entity.getRole());
			}else {
				throw new UserNotFoundException("Please enter valid password");
			}
		} else {
			throw new UserNotFoundException("Please enter valid user name");
		}
		return user;
	}

}
