package calculator.business.calculation;

import javax.ejb.Stateless;

import calculator.model.calculation.CalculationResult;
import calculator.ui.messages.Icons;

@Stateless
public class CalculationService
{

    public CalculationResult solve(final int expected, final int submitted)
    {

        boolean correct = expected == submitted;
        final String message = createMessage(correct);

        return new CalculationResult(message, correct);
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
