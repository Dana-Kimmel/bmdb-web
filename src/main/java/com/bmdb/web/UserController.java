package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.bmdb.business.User;

import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * INSERT 4) PUT - UPDATE 5) DELETE - DELETE
	 */

	@Autowired
	private UserRepo userRepo;

	// Get ALL movies
	@GetMapping("/")
	public List<User> getAll() {
		return userRepo.findAll();
	}

	// Get a movie by id
	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable int id) {
		return userRepo.findById(id);
	}

	// Add a movie
	@PostMapping("/")
	public User addUser(@RequestBody User m) {
		m = userRepo.save(m);
		return m;
	}

	// Update a movie
	@PutMapping("/")
	public User updateUser(@RequestBody User m) {
		m = userRepo.save(m);
		return m;
	}

	// Delete a movie
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) {
		// Optional type will wrap a movie
		Optional<User> m = userRepo.findById(id);
		// isPresent() will return true if a movie was found
		if (m.isPresent()) {
			userRepo.deleteById(id);
		} else {
			System.out.println("Error - movie not found for id " + id);
		}
		return m.get();
	}

}
