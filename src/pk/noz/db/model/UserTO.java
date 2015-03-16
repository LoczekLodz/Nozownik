package pk.noz.db.model;

import java.io.Serializable;
import java.util.Set;

public class UserTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4331377738139936071L;

	private long id;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private Set<UserAddressTO> userAddresses;
	/**
	 * 
	 * Getters and setters section of User Transfer Object
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<UserAddressTO> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddressTO> userAddresses) {
		this.userAddresses = userAddresses;
	}

}
