package pk.noz.db.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Access(AccessType.FIELD)
@Table(name = "order_t")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3002362718972738217L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 100)
	private long id;

	private Date created_t;
	
	private boolean orderSent;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "order_prod_join", 
			joinColumns = @JoinColumn(name = "orderRef", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "prodRef", referencedColumnName = "id"))
	private Set<Product> prodReference;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "assignedUser", referencedColumnName = "id", nullable = false)
	private User assignedUser;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "shipment", referencedColumnName = "id", nullable = false)
	private UserAddress shipment;

	public Date getCreated_t() {
		return created_t;
	}

	public void setCreated_t(Date created_t) {
		this.created_t = created_t;
	}

	public boolean isOrderSent() {
		return orderSent;
	}

	public void setOrderSent(boolean orderSent) {
		this.orderSent = orderSent;
	}

	public Set<Product> getProdReference() {
		return prodReference;
	}

	public void setProdReference(Set<Product> prodReference) {
		this.prodReference = prodReference;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public UserAddress getShipment() {
		return shipment;
	}

	public void setShipment(UserAddress shipment) {
		this.shipment = shipment;
	}

}
