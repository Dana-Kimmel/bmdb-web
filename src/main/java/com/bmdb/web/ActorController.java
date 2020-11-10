package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Actor;

import com.bmdb.db.ActorRepo;


@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {

	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * INSERT 4) PUT - UPDATE 5) DELETE - DELETE
	 */

	@Autowired
	private ActorRepo actorRepo;

	@GetMapping("/")
	public List<Actor> getAll() {
		return actorRepo.findAll();
	}

	// Get an actor by id
	@GetMapping("/{id}")
	public Optional<Actor> getById(@PathVariable int id) {
		return actorRepo.findById(id);
	}

	// Add an actor
	@PostMapping("/")
	public Actor addActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}

	// Update an actor
	@PutMapping("/")
	public Actor updateActor(@RequestBody Actor a) {
		a = actorRepo.save(a);
		return a;
	}

	// Delete an actor
	@DeleteMapping("/{id}")
	public Actor deleteActor(@PathVariable int id) {
		// Optional type will wrap a movie
		Optional<Actor> a = actorRepo.findById(id);
		// isPresent() will return true if an actor was found
		if (a.isPresent()) {
			actorRepo.deleteById(id);
		} else {
			System.out.println("Error - actor not found for id " + id);
		}
		return a.get();
	}

}
