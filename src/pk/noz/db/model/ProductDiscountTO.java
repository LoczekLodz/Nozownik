package pk.noz.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductDiscountTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1600074585712569682L;

	private long id;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	private BigDecimal discount;
	
	private Product parentProd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
