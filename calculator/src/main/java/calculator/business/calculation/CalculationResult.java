package calculator.business.calculation;

public class CalculationResult
{

    private final CalculationRequest request;
    private final Object result;

    public CalculationResult(final CalculationRequest request, final Object result)
    {
        this.request = request;
        this.result = result;
    }

    public CalculationRequest getRequest()
    {
        return request;
    }

    public Object getResult()
    {
        return result;
    }

}
