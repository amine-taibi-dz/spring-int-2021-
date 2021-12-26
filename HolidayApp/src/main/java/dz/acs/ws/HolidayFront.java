package dz.acs.ws;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import dz.acs.ws.message.HolidayRequest;
import dz.acs.ws.message.HolidayResponse;
@WebService(endpointInterface = "dz.acs.ws.HolidayFrontApi", serviceName = "HolidayFront")
public class HolidayFront implements HolidayFrontApi {
	
	@WebMethod()	
	public @WebResult HolidayResponse ask(@WebParam  HolidayRequest holidayRequest) {
		HolidayResponse holidayResponse = new HolidayResponse(holidayRequest);
		Date endDate = holidayRequest.getHoliday().getEndDate();
		Date startDate = holidayRequest.getHoliday().getStartDate();
		if(endDate.before(startDate) || endDate.equals(startDate)) {
			throw new IllegalArgumentException("Date de fin congé est avant ou égale à la date de début"); 
		}else {
			
			long diff = endDate.getTime() - startDate.getTime();
		    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		   
			if(days>=3) {
				holidayResponse.setState(false);
				holidayResponse.setMessage("REFUS");
				holidayResponse.setNbJours((int)days);
			}else {
				holidayResponse.setState(true);
				holidayResponse.setMessage("OK");
				holidayResponse.setNbJours((int)days);				
			}
		}
		return holidayResponse;
	}
}
