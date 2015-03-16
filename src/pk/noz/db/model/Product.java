package pk.noz.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
@Table(name = "product_t")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1160122642598781683L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 100)
	private long id;
	
	private String status;
	
	private boolean availability;

	private String name;
	
	private String description;

	private BigDecimal price;
	
	@OneToMany(mappedBy = "parentProd", cascade = { CascadeType.ALL })
	private Set<ProductImage> productImages;
	
	@OneToMany(mappedBy = "parentProd", cascade = { CascadeType.ALL })
	private Set<ProductDiscount> productDiscount;

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
