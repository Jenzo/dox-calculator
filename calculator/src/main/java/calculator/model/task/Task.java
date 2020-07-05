package calculator.model.task;

import java.math.BigDecimal;

import calculator.model.calculation.Calculation;

public class Task
{

    private final Calculation calculation;

    public Task(final Calculation calculation)
    {
        this.calculation = calculation;
    }

    public Calculation getCalculation()
    {
        return calculation;
    }

    public boolean isCorrectSolved(final BigDecimal submitted)
    {
        return calculation.getResult().compareTo(submitted) == 0;
    }

}
