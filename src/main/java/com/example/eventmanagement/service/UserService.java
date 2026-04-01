package com.example.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eventmanagement.model.User;
import com.example.eventmanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public String login(String username, String password) {

        User user = userRepo.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user.getRole(); // ADMIN or USER
        } else {
            return "INVALID";
        }
    }

    public User register(User user) {
        return userRepo.save(user);
    }

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}