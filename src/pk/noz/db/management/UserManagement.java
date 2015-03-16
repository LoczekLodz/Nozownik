package pk.noz.db.management;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pk.noz.db.model.User;
import pk.noz.db.model.UserAddress;
import pk.noz.db.model.UserAddressTO;
import pk.noz.db.model.UserTO;

@Stateless
public class UserManagement {
	
	@PersistenceContext(unitName = "noz")
	private EntityManager em;

	public void createUser(UserTO user) {
				
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setLogin(user.getLogin());
		newUser.setPassword(user.getPassword());
		
		if(null != user.getUserAddresses()) {
			for (UserAddressTO a : user.getUserAddresses()) {
				UserAddress address = new UserAddress();
				address.setDefaultAddress(a.getDefaultAddress());
				address.setCity(a.getCity());
				address.setStreet(a.getStreet());
				address.setLocaleNum(a.getLocaleNum());
				address.setPostCode(a.getPostCode());
				address.setParentUser(newUser);
				em.persist(address);
			}
		}
		
		em.persist(newUser); 
	}
}
