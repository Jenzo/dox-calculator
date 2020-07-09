package calculator.business.calculation.webservice;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;

@Stateless
public class CalculationGuard
{

    @EJB
    private CalculationApi calculationApi;

    public boolean isValid(final Calculation received)
    {
        final Calculation found = calculationApi.findById(received.getId());
        if(found == null)
        {
            return false;
        }

        return found.getOperand1() == received.getOperand1() && found.getOperand2() == received.getOperand2();
    }

}
