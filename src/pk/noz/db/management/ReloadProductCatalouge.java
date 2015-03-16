package pk.noz.db.management;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;


@Stateless
public class ReloadProductCatalouge extends DefaultHandler {
	
	private Logger logger = Logger.getLogger("com.apress.javaee6");

	private String tempVal;
	
	@PersistenceContext
	private EntityManager em;
	  
	@Schedule(second="0", minute="30",hour="23", persistent=true)
	public void reloadProdCat() {
		testAction();
		parseProdCatFromXml();
	}
	
	private void testAction() {
		logger.log(Level.INFO, "Dzia³a");
	}
	
	private void parseProdCatFromXml() {
		SAXParserFactory spf = SAXParserFactory.newInstance();
			
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse("employees.xml", this);
			
		} catch (SAXException se) {
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
	
	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		//reset
//		tempVal = "";
//		if(qName.equalsIgnoreCase("Employee")) {
//			//create a new instance of employee
//			tempEmp = new Employee();
//			tempEmp.setType(attributes.getValue("type"));
//		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
//		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
//
//		if(qName.equalsIgnoreCase("Employee")) {
//			//add it to the list
//			myEmpls.add(tempEmp);
//			
//		}else if (qName.equalsIgnoreCase("Name")) {
//			tempEmp.setName(tempVal);
//		}else if (qName.equalsIgnoreCase("Id")) {
//			tempEmp.setId(Integer.parseInt(tempVal));
//		}else if (qName.equalsIgnoreCase("Age")) {
//			tempEmp.setAge(Integer.parseInt(tempVal));
//		}
//		
	}
	
	
}
