package pk.noz.db.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
@Table(name = "product_image_t")
public class ProductImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6629556270828258690L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_image_seq")
	@SequenceGenerator(name = "product_image_seq", sequenceName = "product_image_seq", allocationSize = 100)
	private long id;
	
	private String location;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parentProd", referencedColumnName = "id", nullable = false)
	private Product parentProd;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Product getParentProd() {
		return parentProd;
	}

	public void setParentProd(Product parentProd) {
		this.parentProd = parentProd;
	}
}
