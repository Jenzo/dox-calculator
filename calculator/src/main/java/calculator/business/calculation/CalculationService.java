package calculator.business.calculation;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.ws.rs.NotSupportedException;

import calculator.model.calculation.Calculation;

@Stateless
public class CalculationService
{

    public BigDecimal solve(final Calculation calculation)
    {

        final BigDecimal op1 = calculation.getOperand1();
        final BigDecimal op2 = calculation.getOperand2();

        switch(calculation.getOperation())
        {
        case ADD:
            return op1.add(op2);
        case SUB:
            return op1.subtract(op2);
        case MUL:
            return op1.multiply(op2);
        case DIV:
            return op1.divide(op2);
        default:
            throw new NotSupportedException();
        }

    }

    public boolean isPrime(int n)
    {
        if(n <= 0 || n == 1)
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

}
