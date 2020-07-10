package calculator.business.calculation.ws.soap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import calculator.business.calculation.CalculationService;
import calculator.business.calculation.ws.CalculationGuard;
import calculator.business.calculation.ws.CalculationWebServiceException;
import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;
import calculator.model.calculation.CalculationBuilder;

@Stateless
@WebService(serviceName = "WebServiceCalculation")
@SOAPBinding(style = Style.RPC)
public class WSCalculationSOAP
{

    @EJB
    private CalculationService calculationService;

    @EJB
    private CalculationApi calculationApi;

    @EJB
    private CalculationGuard guard;

    @WebMethod
    public Calculation getCalculation()
    {
        final Calculation created = CalculationBuilder.newBuilder().build();
        
        // persist Calculation -> returned Calculation from SOAP-Client can be validated later 
        calculationApi.persist(created);
        
        return created;
    }

    @WebMethod
    public Calculation solveCalculation(@WebParam(name = "calculation") Calculation revceived)
            throws CalculationWebServiceException
    {
        // received Calculation can be validated in CalculationGuard
        guard.validate(revceived);
        
        // if recevied Caluclation is valid -> 
        // solve, merge and return back to SOAP-Client
        return calculationService.solve(revceived);

    }

}
