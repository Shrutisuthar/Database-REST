package com.database.serviceimpl;

import java.util.List;
 import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.database.entity.Database;
import com.database.repository.DatabaseRepository;
import com.database.service.DatabaseService;

@Service
public class DatabaseServiceImpl implements DatabaseService{

	@Autowired
	DatabaseRepository databaseRepository;
	
	@Override
	public ResponseEntity save(Database data) {
		
		Database database = new Database();
		database.setFirstName(data.getFirstName());
		database.setLastName(data.getLastName());
		return ResponseEntity.ok(databaseRepository.save(database));
	}

	
	@Override
	public ResponseEntity findById(Integer id) {
		Optional<Database> data = databaseRepository.findById(id);
		if(!data.isEmpty()) {
			return ResponseEntity.ok(data.get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
		}
	}

	@Override
	public List<Database> getAllData() {
		List<Database> list = (List<Database>)databaseRepository.findAll();
		return list;
	}

	@Override
	public ResponseEntity update(Integer id, Database data) {
		Optional<Database> da = databaseRepository.findById(id);
		if(!da.isEmpty()) {
			Database d = da.get();
			d.setId(data.getId());
			d.setFirstName(data.getFirstName());
			d.setLastName(data.getLastName());
			return ResponseEntity.ok(databaseRepository.save(d));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
		}
	}

	@Override
	public ResponseEntity delete(int id) {
		Optional<Database> da = databaseRepository.findById(id);
		if(!da.isEmpty()) {
			databaseRepository.deleteById(id);
			return ResponseEntity.ok("Deleted successfully");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is not found");
		}
	}

	
}
