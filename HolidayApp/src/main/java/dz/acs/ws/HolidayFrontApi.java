package dz.acs.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import dz.acs.ws.message.HolidayRequest;
import dz.acs.ws.message.HolidayResponse;

@WebService
public interface HolidayFrontApi {
	
	@WebMethod
	public HolidayResponse ask(HolidayRequest holidayRequest) ;

}
