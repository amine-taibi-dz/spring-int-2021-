package dz.acs.ws.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import dz.acs.ws.model.Employee;
import dz.acs.ws.model.Holiday;
/**
 * HolidayResponse
 * @author ataibi
 *
 */
@XmlType(name = "HolidayResponse")
@XmlRootElement
public class HolidayResponse implements Serializable{

	private static final long serialVersionUID = -8440350027057043409L;
	private Employee employee;
	private Holiday holiday;
	private boolean state;
	private String message;
	private int nbJours;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}
	
	
	
	@Override
	public String toString() {
		return "HolidayResponse [employee=" + employee + ", holiday=" + holiday + ", state=" + state + ", message="
				+ message + ", nbJours=" + nbJours + "]";
	}
	public HolidayResponse() {
		super();
	}
	
	
	public HolidayResponse(Employee employee, Holiday holiday, boolean state) {
		super();
		this.employee = employee;
		this.holiday = holiday;
		this.state = state;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public HolidayResponse(HolidayRequest holidayRequest ) {
		super();
		this.employee = holidayRequest.getEmployee();
		this.holiday = holidayRequest.getHoliday();
		this.state = false;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	
   	
}
