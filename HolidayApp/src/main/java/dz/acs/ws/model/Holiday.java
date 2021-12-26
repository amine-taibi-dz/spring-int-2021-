package dz.acs.ws.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlType;
@XmlType(name = "Holiday")
public class Holiday implements Serializable {
 
	private static final long serialVersionUID = 3840307257222259776L;
	private Date startDate;
	private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Holiday(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Holiday() {
		super();
	}
	@Override
	public String toString() {
		return "Holiday [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
