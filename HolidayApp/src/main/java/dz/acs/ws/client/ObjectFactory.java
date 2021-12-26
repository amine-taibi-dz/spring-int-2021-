
package dz.acs.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dz.acs.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AskResponse_QNAME = new QName("http://ws.acs.dz/", "askResponse");
    private final static QName _HolidayRequest_QNAME = new QName("http://ws.acs.dz/", "holidayRequest");
    private final static QName _Ask_QNAME = new QName("http://ws.acs.dz/", "ask");
    private final static QName _HolidayResponse_QNAME = new QName("http://ws.acs.dz/", "holidayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dz.acs.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ask }
     * 
     */
    public Ask createAsk() {
        return new Ask();
    }

    /**
     * Create an instance of {@link AskResponse }
     * 
     */
    public AskResponse createAskResponse() {
        return new AskResponse();
    }

    /**
     * Create an instance of {@link HolidayRequest }
     * 
     */
    public HolidayRequest createHolidayRequest() {
        return new HolidayRequest();
    }

    /**
     * Create an instance of {@link HolidayResponse }
     * 
     */
    public HolidayResponse createHolidayResponse() {
        return new HolidayResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link Holiday }
     * 
     */
    public Holiday createHoliday() {
        return new Holiday();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.acs.dz/", name = "askResponse")
    public JAXBElement<AskResponse> createAskResponse(AskResponse value) {
        return new JAXBElement<AskResponse>(_AskResponse_QNAME, AskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HolidayRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.acs.dz/", name = "holidayRequest")
    public JAXBElement<HolidayRequest> createHolidayRequest(HolidayRequest value) {
        return new JAXBElement<HolidayRequest>(_HolidayRequest_QNAME, HolidayRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.acs.dz/", name = "ask")
    public JAXBElement<Ask> createAsk(Ask value) {
        return new JAXBElement<Ask>(_Ask_QNAME, Ask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HolidayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.acs.dz/", name = "holidayResponse")
    public JAXBElement<HolidayResponse> createHolidayResponse(HolidayResponse value) {
        return new JAXBElement<HolidayResponse>(_HolidayResponse_QNAME, HolidayResponse.class, null, value);
    }

}
