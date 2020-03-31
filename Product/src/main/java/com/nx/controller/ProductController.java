package com.nx.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.nx.entity.ProductPromotion;
import com.nx.entity.Products;
import com.nx.repository.ProductPromotionRepository;
import com.nx.repository.ProductsRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	@GetMapping
	public List<Products> findAll() {
	/*	List<Products> lst = productsRepository.findAll();
		for (Products products : lst) {
			Set<ProductPromotion> setProductPromotion = products.getProductPromotion();
			for (ProductPromotion productPromotion : setProductPromotion) {
				
				System.out.println(productPromotion.get);
			}
		}*/
		
		return productsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> findById(@PathVariable("id") Long id) {
		return productsRepository.findById(id)
				.map(Products -> ResponseEntity.ok().body(Products))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping()
	public Products save(@RequestBody Products Products) {
		return productsRepository.save(Products);
	}
	
	@PutMapping()
	public Products update(@RequestBody Products Products) {
		return productsRepository.save(Products);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		Optional<Products> db = productsRepository.findById(id);
		if(null == db){
			return new ResponseEntity<String>("Id not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		productsRepository.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
}


