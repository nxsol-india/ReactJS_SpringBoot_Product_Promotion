package com.nx.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductPromoPK implements Serializable{

	@Column(name = "product_id")
	private Long productid;
	
	@Column(name = "promocode_id")
	private Long promocodeid;

	public ProductPromoPK() {
		super();
	}
	public ProductPromoPK(Long productid, Long promocodeid) {
		super();
		this.productid = productid;
		this.promocodeid = promocodeid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productid == null) ? 0 : productid.hashCode());
		result = prime * result + ((promocodeid == null) ? 0 : promocodeid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPromoPK other = (ProductPromoPK) obj;
		if (productid == null) {
			if (other.productid != null)
				return false;
		} else if (!productid.equals(other.productid))
			return false;
		if (promocodeid == null) {
			if (other.promocodeid != null)
				return false;
		} else if (!promocodeid.equals(other.promocodeid))
			return false;
		return true;
	}
}
