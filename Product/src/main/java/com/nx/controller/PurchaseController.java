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

import com.nx.entity.Purchase;
import com.nx.repository.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
@CrossOrigin("*")
public class PurchaseController {

	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@GetMapping("/findAll")
	public List<Purchase> findAll() {
		return purchaseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Purchase> findById(@PathVariable("id") Long id) {
		return purchaseRepository.findById(id)
				.map(Purchase -> ResponseEntity.ok().body(Purchase))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public Purchase save(@RequestBody Purchase Purchase) {
		return purchaseRepository.save(Purchase);
	}
	
	@PutMapping()
	public Purchase update(@RequestBody Purchase Purchase) {
		return purchaseRepository.save(Purchase);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Optional<Purchase> db = purchaseRepository.findById(id);
		if(null == db){
			return new ResponseEntity<String>("Id not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		purchaseRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
