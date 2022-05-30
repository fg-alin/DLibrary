package com.application.dlibrary.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			user.getAppointments();
		}
		return userRepository.findAll();
	}

	public User getUserById(Integer id) {
		Optional<User> userOpt = userRepository.findById(id);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
}
