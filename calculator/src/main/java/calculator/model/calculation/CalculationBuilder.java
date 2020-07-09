package calculator.model.calculation;

import java.util.Random;
import java.util.UUID;

public class CalculationBuilder
{
    public static CalculationBuilder newBuilder()
    {
        return new CalculationBuilder();
    }

    private CalculationBuilder()
    {
        operand1 = random.nextInt(boundary);
        operand2 = random.nextInt(boundary);
    }

    private Calculation calculation = new Calculation();
    private Random random = new Random();
    private int boundary = 100;
    private int operand1;
    private int operand2;

    public CalculationBuilder withBoundary(final int boundary)
    {
        this.boundary = boundary;
        return this;
    }

    public Calculation build()
    {
        calculation.setOperand1(operand1);
        calculation.setOperand2(operand2);
        calculation.setUuid(UUID.randomUUID());

        return calculation;
    }

}
