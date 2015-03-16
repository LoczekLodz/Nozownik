package pk.noz.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class ProductTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2614159638497148915L;

	private long id;

	private String status;

	private boolean availability;

	private String name;
	
	private String description;

	private BigDecimal price;
	
	private Set<ProductImage> productImages;
	
	private Set<ProductDiscount> productDiscount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductDiscount> getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Set<ProductDiscount> productDiscount) {
		this.productDiscount = productDiscount;
	}
	
}
