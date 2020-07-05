package calculator.model.calculation;

import java.math.BigDecimal;

public class Calculation
{
    private BigDecimal operand1;
    private BigDecimal operand2;
    private BigDecimal result;
    private Operation operation;

    public Calculation()
    {

    }

    public Calculation(final BigDecimal operand1, final BigDecimal operand2, final Operation operation)
    {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s = ", operand1, operation.getSymbol(), operand2);
    }

    public BigDecimal getOperand1()
    {
        return operand1;
    }

    public void setOperand1(BigDecimal operand1)
    {
        this.operand1 = operand1;
    }

    public BigDecimal getOperand2()
    {
        return operand2;
    }

    public void setOperand2(BigDecimal operand2)
    {
        this.operand2 = operand2;
    }

    public Operation getOperation()
    {
        return operation;
    }

    public void setOperation(Operation operation)
    {
        this.operation = operation;
    }

    public BigDecimal getResult()
    {
        return result;
    }

    public void setResult(BigDecimal result)
    {
        this.result = result;
    }

}
