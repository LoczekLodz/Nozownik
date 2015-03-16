package pk.noz.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class OrderTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3586692972598269653L;

	private long id;

	private Date created_t;
	
	private boolean orderSent;
	
	private Set<OrderItemTO> prodReference;

	private UserTO assignedUser;
	
	private UserAddressTO shipment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Set<OrderItemTO> getProdReference() {
		return prodReference;
	}

	public void setProdReference(Set<OrderItemTO> prodReference) {
		this.prodReference = prodReference;
	}

	public UserTO getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(UserTO assignedUser) {
		this.assignedUser = assignedUser;
	}

	public UserAddressTO getShipment() {
		return shipment;
	}

	public void setShipment(UserAddressTO shipment) {
		this.shipment = shipment;
	}

}
