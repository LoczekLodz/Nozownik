package pk.noz.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "product_discount_t")
public class ProductDiscount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1320886479224233711L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_discount_seq")
	@SequenceGenerator(name = "product_discount_seq", sequenceName = "product_discount_seq", allocationSize = 100)
	private long id;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	private BigDecimal discount;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parentProd", referencedColumnName = "id", nullable = false)
	private Product parentProd;

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Product getParentProd() {
		return parentProd;
	}

	public void setParentProd(Product parentProd) {
		this.parentProd = parentProd;
	}

}
