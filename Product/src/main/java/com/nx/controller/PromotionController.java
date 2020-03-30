package com.nx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nx.entity.Promotion;
import com.nx.repository.PromotionRepository;

@RestController
@RequestMapping("/promo")
@CrossOrigin("*")
public class PromotionController {

	@Autowired
	private PromotionRepository promotionRepository;
	
	@GetMapping("/findAll")
	public List<Promotion> findAll() {
		return promotionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Promotion> findById(@PathVariable("id") Long id) {
		return promotionRepository.findById(id)
				.map(Promotion -> ResponseEntity.ok().body(Promotion))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public Promotion save(@RequestBody Promotion Promotion) {
		return promotionRepository.save(Promotion);
	}
	
	@PutMapping()
	public Promotion update(@RequestBody Promotion Promotion) {
		return promotionRepository.save(Promotion);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Optional<Promotion> db = promotionRepository.findById(id);
		if(null == db){
			return new ResponseEntity<String>("Id not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		promotionRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}