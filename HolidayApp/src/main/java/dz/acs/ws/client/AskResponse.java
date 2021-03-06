
package dz.acs.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour askResponse complex type.
 * 
 * <p>Le fragment de sch?ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="askResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.acs.dz/}HolidayResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "askResponse", propOrder = {
    "_return"
})
public class AskResponse {

    @XmlElement(name = "return")
    protected HolidayResponse _return;

    /**
     * Obtient la valeur de la propri?t? return.
     * 
     * @return
     *     possible object is
     *     {@link HolidayResponse }
     *     
     */
    public HolidayResponse getReturn() {
        return _return;
    }

    /**
     * D?finit la valeur de la propri?t? return.
     * 
     * @param value
     *     allowed object is
     *     {@link HolidayResponse }
     *     
     */
    public void setReturn(HolidayResponse value) {
        this._return = value;
    }

}
