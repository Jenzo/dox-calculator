package calculator.model.calculation;

import java.math.BigDecimal;
import java.util.Random;

public class CalculationBuilder
{
    public static CalculationBuilder newBuilder()
    {
        return new CalculationBuilder();
    }

    private CalculationBuilder()
    {
    }

    private Calculation calculation = new Calculation();
    private Random random = new Random();
    private int boundary;

    public Calculation build()
    {
        final int operand1 = random.nextInt(boundary);
        final int operand2 = random.nextInt(boundary);

        calculation.setOperand1(BigDecimal.valueOf(operand1));
        calculation.setOperand2(BigDecimal.valueOf(operand2));

        return calculation;
    }

    public CalculationBuilder withOperation(final Operation operation)
    {
        calculation.setOperation(operation);
        return this;
    }

    public CalculationBuilder withRandomOperationOf(final Operation... operations)
    {
        Operation randomOperation = operations[random.nextInt(operations.length)];
        calculation.setOperation(randomOperation);

        return this;
    }

    public CalculationBuilder withBoundary(final int boundary)
    {
        this.boundary = boundary;
        return this;
    }

}
