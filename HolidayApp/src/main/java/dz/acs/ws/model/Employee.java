package dz.acs.ws.model;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "Employee")
public class Employee implements Serializable{

	
	private static final long serialVersionUID = -1175595870781773198L;
	private long number;
	private String firstName;
	private String lastName;
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return number == other.number;
	}
	public Employee(long number, String firstName, String lastName) {
		super();
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [number=" + number + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
