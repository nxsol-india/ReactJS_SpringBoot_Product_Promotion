package com.nx.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class ProductPromotion {
	
	@EmbeddedId
	private ProductPromoPK id;
	
	
 
    @ManyToOne()
    @MapsId("promocode_id")
    @JoinColumn(name = "promocode_id")
    Promotion promotion;

	public ProductPromoPK getId() {
		return id;
	}

	public void setId(ProductPromoPK id) {
		this.id = id;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	

	
}
