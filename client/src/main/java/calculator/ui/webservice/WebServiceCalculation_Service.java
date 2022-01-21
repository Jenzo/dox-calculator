
package calculator.ui.webservice;

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
@WebServiceClient(name = "WebServiceCalculation", targetNamespace = "http://webservice.ui.calculator/", wsdlLocation = "http://localhost:8080/WebServiceCalculation/WebServiceCalculation?wsdl")
public class WebServiceCalculation_Service
    extends Service
{

    private final static URL WEBSERVICECALCULATION_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICECALCULATION_EXCEPTION;
    private final static QName WEBSERVICECALCULATION_QNAME = new QName("http://webservice.ui.calculator/", "WebServiceCalculation");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebServiceCalculation/WebServiceCalculation?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICECALCULATION_WSDL_LOCATION = url;
        WEBSERVICECALCULATION_EXCEPTION = e;
    }

    public WebServiceCalculation_Service() {
        super(__getWsdlLocation(), WEBSERVICECALCULATION_QNAME);
    }

    public WebServiceCalculation_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICECALCULATION_QNAME, features);
    }

    public WebServiceCalculation_Service(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICECALCULATION_QNAME);
    }

    public WebServiceCalculation_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICECALCULATION_QNAME, features);
    }

    public WebServiceCalculation_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceCalculation_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceCalculation
     */
    @WebEndpoint(name = "WebServiceCalculationPort")
    public WebServiceCalculation getWebServiceCalculationPort() {
        return super.getPort(new QName("http://webservice.ui.calculator/", "WebServiceCalculationPort"), WebServiceCalculation.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceCalculation
     */
    @WebEndpoint(name = "WebServiceCalculationPort")
    public WebServiceCalculation getWebServiceCalculationPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://webservice.ui.calculator/", "WebServiceCalculationPort"), WebServiceCalculation.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICECALCULATION_EXCEPTION!= null) {
            throw WEBSERVICECALCULATION_EXCEPTION;
        }
        return WEBSERVICECALCULATION_WSDL_LOCATION;
    }

}