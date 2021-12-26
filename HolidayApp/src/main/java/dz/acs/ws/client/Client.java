package dz.acs.ws.client;

import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class Client {

	private static final String LOCATION_WSDL = "http://localhost:9000/holiday/HolidayFrontService?wsdl";

	public static void main(String[] args) throws Exception {
		URL wsdlLocation = new URL(LOCATION_WSDL);
		HolidayFront hf = new HolidayFront(wsdlLocation);
		HolidayFrontApi holidayFrontPort = hf.getHolidayFrontPort();
		HolidayRequest hr = new HolidayRequest();
		Employee employee = new Employee();
		employee.setFirstName("Amine");
		employee.setLastName("TAIBI");
		employee.setNumber(1_000);
		
		hr.setEmployee(employee);
		Holiday holiday = new Holiday();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new Date());
		XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		   
		holiday.setEndDate(date1);
		holiday.setStartDate(date1);
		hr.setHoliday(holiday );
		HolidayResponse ask = holidayFrontPort.ask(hr);
		System.out.println( ask);
				
		

	}

}
