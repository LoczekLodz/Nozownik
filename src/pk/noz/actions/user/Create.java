package pk.noz.actions.user;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pk.noz.db.management.UserManagement;
import pk.noz.db.model.UserAddressTO;
import pk.noz.db.model.UserTO;

/**
 * Servlet implementation class create
 */
@WebServlet("/create")
public class Create extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@EJB
	private UserManagement userManagment;
	
    public Create() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("UTF-8");
		
		UserTO newUser = new UserTO();
		newUser.setFirstName("Piotr");
		newUser.setLastName("Loku");
		newUser.setLogin("piotrloczek");
		newUser.setPassword("hwdp");
		
		Set<UserAddressTO> userAddressesList = new HashSet<UserAddressTO>(5);
		
		UserAddressTO address= new UserAddressTO();
		address.setParentUser(newUser);
		address.setCity("£Ûdü");
		address.setPostCode("90-368 £Ûdü");
		address.setStreet("Piotrkowska 182");
		address.setLocaleNum("499");
		address.setDefaultAddress(true);
		userAddressesList.add(address);
		
		newUser.setUserAddresses(userAddressesList);
		userManagment.createUser(newUser);
	}

}
