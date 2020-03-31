package com.nx.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Products implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="product_code")
	private String productCode;

	@Column(name="product_name")
	private String productName;

	@Column(name="price_per_month")
	private Double pricePerMonth;


	@OneToMany(mappedBy = "promotion")
	Set<ProductPromotion> productPromotion;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPricePerMonth() {
		return pricePerMonth;
	}

	public void setPricePerMonth(Double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Set<ProductPromotion> getProductPromotion() {
		return productPromotion;
	}

	public void setProductPromotion(Set<ProductPromotion> productPromotion) {
		this.productPromotion = productPromotion;
	}

}