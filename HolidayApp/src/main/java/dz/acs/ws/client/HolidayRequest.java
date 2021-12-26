
package dz.acs.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour HolidayRequest complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="HolidayRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employee" type="{http://ws.acs.dz/}Employee" minOccurs="0"/>
 *         &lt;element name="holiday" type="{http://ws.acs.dz/}Holiday" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HolidayRequest", propOrder = {
    "employee",
    "holiday"
})
public class HolidayRequest {

    protected Employee employee;
    protected Holiday holiday;

    /**
     * Obtient la valeur de la propri�t� employee.
     * 
     * @return
     *     possible object is
     *     {@link Employee }
     *     
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * D�finit la valeur de la propri�t� employee.
     * 
     * @param value
     *     allowed object is
     *     {@link Employee }
     *     
     */
    public void setEmployee(Employee value) {
        this.employee = value;
    }

    /**
     * Obtient la valeur de la propri�t� holiday.
     * 
     * @return
     *     possible object is
     *     {@link Holiday }
     *     
     */
    public Holiday getHoliday() {
        return holiday;
    }

    /**
     * D�finit la valeur de la propri�t� holiday.
     * 
     * @param value
     *     allowed object is
     *     {@link Holiday }
     *     
     */
    public void setHoliday(Holiday value) {
        this.holiday = value;
    }

}
