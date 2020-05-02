package com.certimetergroup.learnMongoDB.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.certimetergroup.learnMongoDB.model.Unicorn;
import com.certimetergroup.learnMongoDB.repository.UnicornRepository;

@RestController
@RequestMapping("/unicorn")
public class UnicornController {

	final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private UnicornRepository unicornRepository;
	
	
	
	@GetMapping("/name")
	public ResponseEntity<String> getUnicornByName( @RequestParam String name ){
		LOG.info("##### getUnicornByName - name: " + name + " #####");
		
		Unicorn unicorn = unicornRepository.findByName(name);
		
		return ResponseEntity.ok().body( 
			unicorn==null? "NOT FOUND":unicorn.toString()
		);
	}
	
	@GetMapping("/gender")
	public ResponseEntity<String> getUnicornsByGender( @RequestParam String gender ){
		LOG.info("##### getUnicornsByGender - gender: " + gender + " #####");
		
		ArrayList<Unicorn> unicorns = unicornRepository.findUnicornByGender(gender);
		
		return ResponseEntity.ok().body( 
			unicorns.toString()
		);
	}

	@GetMapping("/{idUnicorn}")
	public ResponseEntity<String> getUnicornByIdUnicorn( @PathVariable String idUnicorn ){
		LOG.info("##### getUnicornByIdUnicorn - idUnicorn: " + idUnicorn + " #####");
		
		Unicorn unicorn = unicornRepository.findByIdUnicorn(idUnicorn);
		
		return ResponseEntity.ok().body( 
			unicorn.toString()
		);
	}
	
	@PostMapping
	public ResponseEntity<String> insertUnicorn( @RequestBody Unicorn unicorn ){
		LOG.info("##### insertUnicorn - unicorn: " + unicorn + " #####");
		
		Unicorn unicornInserted = unicornRepository.save(unicorn);
		LOG.info("unicornInserted => " + unicornInserted);
		
		ArrayList<Unicorn> unicorns = (ArrayList<Unicorn>) unicornRepository.findAll();
		
		return ResponseEntity.ok().body( 
			unicorns.toString()
		);
	}
	
	@DeleteMapping("/{idUnicorn}")
	public ResponseEntity<String> deleteUnicorn( @PathVariable String idUnicorn ){
		LOG.info("##### deleteUnicorn - idUnicorn: " + idUnicorn + " #####");
		
		Unicorn unicornToDelete = unicornRepository.findByIdUnicorn(idUnicorn);
		LOG.info("----- unicornToDelete => " + unicornToDelete);
		
		unicornRepository.delete(unicornToDelete);
		
		ArrayList<Unicorn> unicorns = (ArrayList<Unicorn>) unicornRepository.findAll();
		
		return ResponseEntity.ok().body( 
			unicorns.toString()
		);
	} 
	
	@PatchMapping("/{idUnicorn}/loves")
	public ResponseEntity<String> updateLovesByIdUnicorn( @PathVariable String idUnicorn, @RequestParam ArrayList<String> loves ){
		LOG.info("##### updateLovesByIdUnicorn - idUnicorn: " + idUnicorn + " #####");
		
		Unicorn unicornFromDB = unicornRepository.findByIdUnicorn(idUnicorn);
		LOG.info("----- unicornFromDB => " + unicornFromDB);
		
		unicornFromDB.setLoves(loves);
		int numRowsAffected = unicornRepository.updateLovesByIdUnicorn(unicornFromDB);
		LOG.info("numRowsAffected => " + numRowsAffected);
		
		ArrayList<Unicorn> unicorns = (ArrayList<Unicorn>) unicornRepository.findAll();
		
		return ResponseEntity.ok().body( 
			unicorns.toString()
		);
	} 
	
	@PutMapping
	public ResponseEntity<String> updateUnicorn( @RequestBody Unicorn unicorn ){
		LOG.info("##### updateUnicorn - unicorn: " + unicorn + " #####");
		
		Unicorn unicornFromDB = unicornRepository.findByIdUnicorn(unicorn.getIdUnicorn());
		LOG.info("----- unicornFromDB => " + unicornFromDB);
		
		int numRowsAffected = unicornRepository.updateUnicornByIdUnicorn(unicorn);
		LOG.info("numRowsAffected => " + numRowsAffected);
		
		ArrayList<Unicorn> unicorns = (ArrayList<Unicorn>) unicornRepository.findAll();
		
		return ResponseEntity.ok().body( 
			unicorns.toString()
		);
	}
	
}
