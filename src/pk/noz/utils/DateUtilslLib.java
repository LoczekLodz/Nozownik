package pk.noz.utils;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.StringUtils;


public class DateUtilslLib {
	
	private static Logger logger = Logger.getLogger("com.apress.javaee6");

	public static XMLGregorianCalendar getXmlGregorianCalendar(final String value) {
		if (StringUtils.trimToNull(value) == null) {
			return null;
		}
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
		} catch (DatatypeConfigurationException dte) {
			logger.log(Level.SEVERE, dte.getMessage(), dte);
		}
		return null;
	}
	public static Date parseXmlDate(final String value) {
        XMLGregorianCalendar xmlGregorianCalendar = getXmlGregorianCalendar(value);
        return xmlGregorianCalendar == null ? null : xmlGregorianCalendar.toGregorianCalendar().getTime();
    }
}
