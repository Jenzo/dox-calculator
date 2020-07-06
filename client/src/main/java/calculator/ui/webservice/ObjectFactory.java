
package calculator.ui.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calculator.ui.webservice package. 
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

    private final static QName _GetCalculation_QNAME = new QName("http://webservice.ui.calculator/", "getCalculation");
    private final static QName _SolveCalculation_QNAME = new QName("http://webservice.ui.calculator/", "solveCalculation");
    private final static QName _CalculationServiceException_QNAME = new QName("http://webservice.ui.calculator/", "CalculationServiceException");
    private final static QName _SolveCalculationResponse_QNAME = new QName("http://webservice.ui.calculator/", "solveCalculationResponse");
    private final static QName _GetCalculationResponse_QNAME = new QName("http://webservice.ui.calculator/", "getCalculationResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculator.ui.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCalculation }
     * 
     */
    public GetCalculation createGetCalculation() {
        return new GetCalculation();
    }

    /**
     * Create an instance of {@link SolveCalculation }
     * 
     */
    public SolveCalculation createSolveCalculation() {
        return new SolveCalculation();
    }

    /**
     * Create an instance of {@link CalculationServiceException }
     * 
     */
    public CalculationServiceException createCalculationServiceException() {
        return new CalculationServiceException();
    }

    /**
     * Create an instance of {@link GetCalculationResponse }
     * 
     */
    public GetCalculationResponse createGetCalculationResponse() {
        return new GetCalculationResponse();
    }

    /**
     * Create an instance of {@link SolveCalculationResponse }
     * 
     */
    public SolveCalculationResponse createSolveCalculationResponse() {
        return new SolveCalculationResponse();
    }

    /**
     * Create an instance of {@link Calculation }
     * 
     */
    public Calculation createCalculation() {
        return new Calculation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalculation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ui.calculator/", name = "getCalculation")
    public JAXBElement<GetCalculation> createGetCalculation(GetCalculation value) {
        return new JAXBElement<GetCalculation>(_GetCalculation_QNAME, GetCalculation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveCalculation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ui.calculator/", name = "solveCalculation")
    public JAXBElement<SolveCalculation> createSolveCalculation(SolveCalculation value) {
        return new JAXBElement<SolveCalculation>(_SolveCalculation_QNAME, SolveCalculation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculationServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ui.calculator/", name = "CalculationServiceException")
    public JAXBElement<CalculationServiceException> createCalculationServiceException(CalculationServiceException value) {
        return new JAXBElement<CalculationServiceException>(_CalculationServiceException_QNAME, CalculationServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolveCalculationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ui.calculator/", name = "solveCalculationResponse")
    public JAXBElement<SolveCalculationResponse> createSolveCalculationResponse(SolveCalculationResponse value) {
        return new JAXBElement<SolveCalculationResponse>(_SolveCalculationResponse_QNAME, SolveCalculationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCalculationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.ui.calculator/", name = "getCalculationResponse")
    public JAXBElement<GetCalculationResponse> createGetCalculationResponse(GetCalculationResponse value) {
        return new JAXBElement<GetCalculationResponse>(_GetCalculationResponse_QNAME, GetCalculationResponse.class, null, value);
    }

}
