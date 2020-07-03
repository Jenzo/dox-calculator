package calculator.business.calculation;

public class CalculationRequest
{
    private final Object operand1;
    private final Object operand2;
    private final Operation operation;

    public CalculationRequest(final Object operand1, final Object operand2, final Operation operation)
    {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public Object getOperand1()
    {
        return operand1;
    }

    public Object getOperand2()
    {
        return operand2;
    }

    public Operation getOperation()
    {
        return operation;
    }

}
