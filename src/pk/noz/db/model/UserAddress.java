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
@Table(name = "user_address_t")
public class UserAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6829087138657260453L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_address_seq")
	@SequenceGenerator(name = "user_address_seq", sequenceName = "user_address_seq", allocationSize = 100)
	private long id;
	
	private Boolean defaultAddress;
	
	private String street;
	
	private String localeNum;
	
	private String city;
	
	private String postCode;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "parent", referencedColumnName = "id", nullable = false)
	private User parentUser;

	public Boolean getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocaleNum() {
		return localeNum;
	}

	public void setLocaleNum(String localeNum) {
		this.localeNum = localeNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public User getParentUser() {
		return parentUser;
	}

	public void setParentUser(User parentUser) {
		this.parentUser = parentUser;
	}

}
