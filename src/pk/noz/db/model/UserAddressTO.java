package pk.noz.db.model;

import java.io.Serializable;

public class UserAddressTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4372627575569012817L;

	private long id;
	
	private Boolean defaultAddress;
	
	private String street;
	
	private String localeNum;
	
	private String city;
	
	private String postCode;
	
	private UserTO parentUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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

	public UserTO getParentUser() {
		return parentUser;
	}

	public void setParentUser(UserTO parentUser) {
		this.parentUser = parentUser;
	}
	
}
