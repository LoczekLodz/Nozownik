package pk.noz.db.model;

import java.io.Serializable;

public class OrderItemTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8016231432503189832L;

	private long orderRef;
	
	private long prodRef;

	public long getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(long orderRef) {
		this.orderRef = orderRef;
	}

	public long getProdRef() {
		return prodRef;
	}

	public void setProdRef(long prodRef) {
		this.prodRef = prodRef;
	}
	
}
