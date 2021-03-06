
package dz.acs.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HolidayFront", targetNamespace = "http://ws.acs.dz/", wsdlLocation = "http://localhost:9000/holiday/HolidayFrontService?wsdl")
public class HolidayFront
    extends Service
{

    private final static URL HOLIDAYFRONT_WSDL_LOCATION;
    private final static WebServiceException HOLIDAYFRONT_EXCEPTION;
    private final static QName HOLIDAYFRONT_QNAME = new QName("http://ws.acs.dz/", "HolidayFront");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/holiday/HolidayFrontService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOLIDAYFRONT_WSDL_LOCATION = url;
        HOLIDAYFRONT_EXCEPTION = e;
    }

    public HolidayFront() {
        super(__getWsdlLocation(), HOLIDAYFRONT_QNAME);
    }

    public HolidayFront(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOLIDAYFRONT_QNAME, features);
    }

    public HolidayFront(URL wsdlLocation) {
        super(wsdlLocation, HOLIDAYFRONT_QNAME);
    }

    public HolidayFront(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOLIDAYFRONT_QNAME, features);
    }

    public HolidayFront(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HolidayFront(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HolidayFrontApi
     */
    @WebEndpoint(name = "HolidayFrontPort")
    public HolidayFrontApi getHolidayFrontPort() {
        return super.getPort(new QName("http://ws.acs.dz/", "HolidayFrontPort"), HolidayFrontApi.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HolidayFrontApi
     */
    @WebEndpoint(name = "HolidayFrontPort")
    public HolidayFrontApi getHolidayFrontPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.acs.dz/", "HolidayFrontPort"), HolidayFrontApi.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOLIDAYFRONT_EXCEPTION!= null) {
            throw HOLIDAYFRONT_EXCEPTION;
        }
        return HOLIDAYFRONT_WSDL_LOCATION;
    }

}
