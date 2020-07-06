package calculator.business.calculation;

import javax.ejb.Stateless;

import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationBuilder;

@Stateless
public class CalculationProviderBean
{

    public Calculation createNewCalculation(final int boundary)
    {
        return CalculationBuilder.newBuilder().withBoundary(boundary).build();

    }

}
