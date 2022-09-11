package com.database.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import com.database.entity.Database;
public interface DatabaseService {

	public ResponseEntity save(Database data);

	public ResponseEntity findById(Integer id);

	public List<Database> getAllData();

	public ResponseEntity update(Integer id, Database data);

	public ResponseEntity delete(int id);

}
