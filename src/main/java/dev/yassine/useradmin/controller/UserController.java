package dev.yassine.useradmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.yassine.useradmin.model.User;
import dev.yassine.useradmin.repository.UserRepository;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	User newUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	@GetMapping("/users")
	List<User> getUsers() {
		return this.userRepository.findAll();
	}
	
	

}
