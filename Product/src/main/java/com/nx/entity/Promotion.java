package com.nx.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="promotion")
public class Promotion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="promo_code")
	private String promoCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="discount")
	private Long discount;
	
	@Column(name="minimum_bill_Value")
	private Double minMumBill;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDiscount() {
		return discount;
	}

	public void setDiscount(Long discount) {
		this.discount = discount;
	}

	public Double getMinMumBill() {
		return minMumBill;
	}

	public void setMinMumBill(Double minMumBill) {
		this.minMumBill = minMumBill;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}