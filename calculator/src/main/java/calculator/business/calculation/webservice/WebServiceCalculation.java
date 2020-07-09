package calculator.business.calculation.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import calculator.business.calculation.CalculationService;
import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;
import calculator.model.calculation.CalculationBuilder;

@Stateless
@WebService(serviceName = "WebServiceCalculation")
public class WebServiceCalculation
{

    private Logger LOG = LoggerFactory.getLogger(WebServiceCalculation.class);

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
        calculationApi.persist(created);
        return created;
    }

    @WebMethod
    public Calculation solveCalculation(@WebParam(name = "calculation") Calculation calculation)
            throws CalculationWebServiceException
    {
        if(guard.isValid(calculation))
        {
            return calculationService.solve(calculation);
        }
        else
        {
            calculationApi.remove(calculation);
            LOG.warn(
                    "Möglicher Täuschungsversuch!! Die Aufgaben stimmen nicht überein. Die Operanden sind unterschiedlich.");
            throw new CalculationWebServiceException(
                    "Möglicher Täuschungsversuch!! Die Aufgaben stimmen nicht überein. Die Operanden sind unterschiedlich.");
        }

    }

}
