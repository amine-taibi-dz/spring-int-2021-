package dz.acs.ws.message;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import dz.acs.ws.model.Employee;
import dz.acs.ws.model.Holiday;
/**
 * HolidayRequest
 * @author ataibi
 *
 */
@XmlType(name = "HolidayRequest")
@XmlRootElement
public class HolidayRequest implements Serializable{

	private static final long serialVersionUID = -411986817109673560L;
	private Employee employee;
	private Holiday holiday;
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
		return "HolidayRequest [employee=" + employee + ", holiday=" + holiday + "]";
	}
	public HolidayRequest() {
		super();
	}
	public HolidayRequest(Employee employee, Holiday holiday) {
		super();
		this.employee = employee;
		this.holiday = holiday;
	}
	
	
	
   	
}
