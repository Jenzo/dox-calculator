package calculator.business.task;

import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import calculator.business.calculation.CalculationService;
import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationBuilder;
import calculator.model.calculation.Operation;
import calculator.model.task.Task;

@Stateless
public class TaskProviderBean
{

    @EJB
    private CalculationService calculationService;

    public Task createTask()
    {
        final Calculation calculation = CalculationBuilder.newBuilder().withRandomOperationOf(
                Operation.ADD,
                Operation.SUB).withBoundary(100).build();

        final BigDecimal result = calculationService.solve(calculation);
        calculation.setResult(result);

        return new Task(calculation);

    }

}
