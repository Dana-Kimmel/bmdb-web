package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Credit;
import com.bmdb.business.Movie;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	/*
	 * A controller will implement 5 CRUD methods: 1) GET ALL 2) GET BY ID 3) POST -
	 * INSERT 4) PUT - UPDATE 5) DELETE - DELETE
	 */
	
	
	@Autowired
	private CreditRepo creditRepo;
	
	// Get ALL credits
		@GetMapping("/")
		public List<Credit> getAll() {
			return creditRepo.findAll();
		}

		// Get a credit by id
		@GetMapping("/{id}")
		public Optional<Credit> getById(@PathVariable int id) {
			return creditRepo.findById(id);
		}
		
		// Add a credit
		@PostMapping("/")
		public Credit addCredit(@RequestBody Credit c) {
			c = creditRepo.save(c);
			return c;
		}
		
		// Update a movie
		@PutMapping("/")
		public Credit updateCredit(@RequestBody Credit c) {
			c = creditRepo.save(c);
			return c;
		}
		
		// Delete a movie
		@DeleteMapping("/{id}")
		public Credit deleteCredit(@PathVariable int id) {
			// Optional type will wrap a credit
			Optional<Credit> c = creditRepo.findById(id);
			// isPresent() will return true if a credit was found
			if (c.isPresent()) {
				creditRepo.deleteById(id);
			} else {
				System.out.println("Error - credit not found for id " + id);
			}
			return c.get();
		}
}
