package calculator.business.calculation;

import javax.ejb.Stateless;

import calculator.ui.messages.Icons;

@Stateless
public class CalculationService
{

    public CalculationUIResult solve(final CalculationRequest request, final Object submittedResult)
    {

        final CalculationResult calResult = solve(request);

        boolean correct = calResult.getResult() == submittedResult;
        final String message = createMessage(correct);

        return new CalculationUIResult(message, correct);
    }

    public CalculationResult solve(final CalculationRequest request)
    {
        switch(request.getOperation())
        {
        case ADD:
            return solveAdd(request);
        default:
            return new CalculationResult(request, null);
        }
    }

    private CalculationResult solveAdd(CalculationRequest r)
    {
        int op1 = (int)r.getOperand1();
        int op2 = (int)r.getOperand2();
        return new CalculationResult(r, op1 + op2);
    }

    public boolean isPrime(int n)
    {
        if(n == 0 || n == 1)
        {
            return false;
        }

        boolean isPrime = false;
        for(int i = 2; i <= n / 2; ++i)
        {
            if(n % i == 0)
            {
                isPrime = true;
                break;
            }
        }

        return !isPrime;

    }

    private String createMessage(final boolean correct)
    {

        if(correct)
        {
            return String.format(
                    "Dein Ergebnis ist richtig {0} %s </br> Weiter zur nächsten Aufgabe",
                    Icons.getSmileO());
        }
        else
        {
            return String.format(
                    "Das ist leider nicht richtig {0} %s </br>Versuche es nochmal oder hole Dir einen Tipp",
                    Icons.getMehO());
        }

    }

}
