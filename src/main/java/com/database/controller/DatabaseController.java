package com.database.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.entity.Database;
import com.database.service.DatabaseService;

@RestController
@RequestMapping("/api/database")
public class DatabaseController {
	
	@Autowired 
	DatabaseService databaseService;
	
	@PostMapping
	public ResponseEntity addEmployee(Database data) {

		return databaseService.save(data);
		
	}
	
	@GetMapping("/database/{id}")
	public ResponseEntity findById(@PathVariable("id") Integer id) {
		return databaseService.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Database>> getData() {

		List<Database> list = databaseService.getAllData();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@RequestBody  Database data,@PathVariable("id") Integer id) {
		return databaseService.update(id, data);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		return databaseService.delete(id);
	}
}
