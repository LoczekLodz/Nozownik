package pk.noz.db.management;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pk.noz.db.model.Product;
import pk.noz.db.model.ProductDiscount;
import pk.noz.db.model.ProductImage;
import pk.noz.utils.DateUtilslLib;

@Stateless
public class ReloadProductCatalouge extends DefaultHandler {
	
	private Logger logger = Logger.getLogger("com.apress.javaee6");

	private String tagValue;
	private Set<Product> productCatList= new HashSet<Product>(30);
	
	private Product tmpProd;
	private ProductDiscount tmpProdDisc;
	private ProductImage tmpProdImage;
	
	private Set<ProductDiscount> tmpProdDiscList = new HashSet<ProductDiscount>(5);
	private Set<ProductImage> tmpProdImageList = new HashSet<ProductImage>(5);
	
	private Date prodCatDate;
	
	@PersistenceContext
	private EntityManager em;
	  
	@SuppressWarnings("deprecation")
	@Schedule(second="*/5", minute="*",hour="*", persistent=true)
	public void reloadProdCat() {
		logInfo("Product Catalouge - Starting reloading procedure");
		logInfo("Product Catalouge - Parsing xml file");
		parseProdCatFromXml();
		logInfo("Product Catalouge - Loading into DB");
		backupAndDeleteOldData();
		reloadDBProdCat();
		logInfo("Product Catalouge succesfully loaded from " + prodCatDate.toGMTString());
	}
	
	private void logInfo(String s) {
		logger.log(Level.INFO, s);
	}
	
	private void parseProdCatFromXml() {
		//clear old temporary lists
		productCatList.clear();
		tmpProdDiscList.clear();
		tmpProdImageList.clear();
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
			
		try {
			SAXParser sp = spf.newSAXParser();
			sp.parse("webapps/Nozownik/prodCat.xml", this);
			
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
		tagValue = "";
		if(qName.equals("Product")) {
			tmpProd = new Product();
		}
		if(qName.equals("productImages")) {
			tmpProdImage = new ProductImage();
		}
		if(qName.equals("productDiscount")) {
			tmpProdDisc = new ProductDiscount();
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tagValue = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("Product")) {
			tmpProd.setProductImages(tmpProdImageList);
			tmpProd.setProductDiscount(tmpProdDiscList);
			productCatList.add(tmpProd);
			tmpProdDiscList = new HashSet<ProductDiscount>(5);
			tmpProdImageList = new HashSet<ProductImage>(5);
		} else if (qName.equals("productImages")) {
			tmpProdImageList.add(tmpProdImage);
		} else if (qName.equals("productDiscount")) {
			tmpProdDiscList.add(tmpProdDisc);
		}
		//Product parsing
		else if (qName.equals("name")) {
			tmpProd.setName(tagValue);
		} else if (qName.equals("description")) {
			tmpProd.setDescription(tagValue);
		} else if (qName.equals("status")) {
			tmpProd.setStatus(tagValue);
		} else if (qName.equals("availability")) {
			tmpProd.setAvailability(Boolean.parseBoolean(tagValue));
		} else if (qName.equals("price")) {
			tagValue.replace(",", ".");
			tmpProd.setPrice(new BigDecimal(tagValue));
		}
		//Product Images parsing
		else if (qName.equals("location")) {
			tmpProdImage.setParentProd(tmpProd);
			tmpProdImage.setLocation(tagValue);
		}
		//Product Discounts parsing
		else if (qName.equals("dateFrom")) {
			tmpProdDisc.setDateFrom(DateUtilslLib.parseXmlDate(tagValue));
		} else if (qName.equals("dateTo")) {
			tmpProdDisc.setDateTo(DateUtilslLib.parseXmlDate(tagValue));
		} else if (qName.equals("discount")) {
			tagValue.replaceAll(",", ".");
			tmpProdDisc.setDiscount(new BigDecimal(tagValue));
			tmpProdDisc.setParentProd(tmpProd);
		}
		//Product Cat date
		else if (qName.equals("date")) {
			prodCatDate = DateUtilslLib.parseXmlDate(tagValue);
		}
	}
	
	private void backupAndDeleteOldData() {
		Query q = em.createNamedQuery("findAllProds");
		@SuppressWarnings("unchecked")
		final List<Product> products = q.getResultList();
		for (Product p : products) {
			em.remove(p);
		}
	}
	
	private void reloadDBProdCat() {
		for (Product p : productCatList) {
			em.persist(p);
		}
	}
}
