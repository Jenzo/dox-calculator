package calculator.ui.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import calculator.business.calculation.CalculationService;
import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationBuilder;

@Stateless
@WebService(serviceName = "WebServiceCalculation")
public class WebServiceCalculation
{

    @EJB
    private CalculationService calculationService;

    @EJB
    private CalculationGuard guard;

    @WebMethod
    public Calculation getCalculation()
    {
        final Calculation created = CalculationBuilder.newBuilder().build();
        guard.setCreated(created);

        return created;
    }

    @WebMethod
    public Calculation solveCalculation(@WebParam(name = "calculation") Calculation calculation)
            throws CalculationServiceException
    {
        guard.setReceived(calculation);
        if(guard.valid())
        {
            return calculationService.solve(calculation);
        }
        else
        {
            throw new CalculationServiceException(
                    "Möglicher Täuschungsversuch!! "
                            + "Die Aufgaben stimmen nicht überein. Die Operanden sind unterschiedlich.");
        }

    }

}
