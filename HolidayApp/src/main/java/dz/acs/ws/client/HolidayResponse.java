
package dz.acs.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour HolidayResponse complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="HolidayResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employee" type="{http://ws.acs.dz/}Employee" minOccurs="0"/>
 *         &lt;element name="holiday" type="{http://ws.acs.dz/}Holiday" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nbJours" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HolidayResponse", propOrder = {
    "employee",
    "holiday",
    "message",
    "nbJours",
    "state"
})
public class HolidayResponse {

    protected Employee employee;
    protected Holiday holiday;
    protected String message;
    protected int nbJours;
    protected boolean state;

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

    /**
     * Obtient la valeur de la propri�t� message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * D�finit la valeur de la propri�t� message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obtient la valeur de la propri�t� nbJours.
     * 
     */
    public int getNbJours() {
        return nbJours;
    }

    /**
     * D�finit la valeur de la propri�t� nbJours.
     * 
     */
    public void setNbJours(int value) {
        this.nbJours = value;
    }

    /**
     * Obtient la valeur de la propri�t� state.
     * 
     */
    public boolean isState() {
        return state;
    }

    /**
     * D�finit la valeur de la propri�t� state.
     * 
     */
    public void setState(boolean value) {
        this.state = value;
    }

}
