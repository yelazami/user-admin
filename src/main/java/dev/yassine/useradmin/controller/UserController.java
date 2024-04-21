package dev.yassine.useradmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.yassine.useradmin.exception.UserNotFoundException;
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
	
	@GetMapping("/user/{id}")
	User getUser(@PathVariable Long id) {
		return this.userRepository.findById(id)
					.orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		return this.userRepository.findById(id)
				.map( user -> {
					
					user.setName(newUser.getName());
					user.setUsername(newUser.getUsername());
					user.setEmail(newUser.getEmail());
					
					return this.userRepository.save(user);
				})
				.orElseThrow(() -> new UserNotFoundException(id))
		;
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Long id) {
		if (!this.userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		
		this.userRepository.deleteById(id);
		
		return "User "+id+" is deleted !";
	}
	
	

}
