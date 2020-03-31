package com.nx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="total_no_of_product")
	private Long totalNoOfProduct;
	
	@ManyToOne
	@JoinColumn(name="promo_code_id")
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(name="product")
	private Products products;
	
	@Column(name="total")
	private Double total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Long getTotalNoOfProduct() {
		return totalNoOfProduct;
	}

	public void setTotalNoOfProduct(Long totalNoOfProduct) {
		this.totalNoOfProduct = totalNoOfProduct;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}