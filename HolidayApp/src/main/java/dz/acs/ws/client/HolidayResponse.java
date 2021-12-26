
package dz.acs.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour HolidayResponse complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
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
     * Obtient la valeur de la propriété employee.
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
     * Définit la valeur de la propriété employee.
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
     * Obtient la valeur de la propriété holiday.
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
     * Définit la valeur de la propriété holiday.
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
     * Obtient la valeur de la propriété message.
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
     * Définit la valeur de la propriété message.
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
     * Obtient la valeur de la propriété nbJours.
     * 
     */
    public int getNbJours() {
        return nbJours;
    }

    /**
     * Définit la valeur de la propriété nbJours.
     * 
     */
    public void setNbJours(int value) {
        this.nbJours = value;
    }

    /**
     * Obtient la valeur de la propriété state.
     * 
     */
    public boolean isState() {
        return state;
    }

    /**
     * Définit la valeur de la propriété state.
     * 
     */
    public void setState(boolean value) {
        this.state = value;
    }

}
