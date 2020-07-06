package calculator.business.calculation;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.NotSupportedException;

import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;
import calculator.model.calculation.Operation;

@Stateless
public class CalculationService
{

    @EJB
    private CalculationApi calculationApi;

    public Calculation solve(final Calculation calculation)
    {
        final int expectedResult = solve(calculation.getOperand1(), calculation.getOperand2(), Operation.ADD);
        final boolean solved = expectedResult == calculation.getUserResult();

        calculation.setCorrectSolved(solved);
        calculation.setSubmittedAt(new Date());
        calculationApi.persist(calculation);

        return calculation;
    }

    private int solve(int operand1, int operand2, Operation operation)
    {
        switch(operation)
        {
        case ADD:
            return solveAdd(operand1, operand2);
        case SUB:
            return solveSub(operand1, operand2);
        default:
            final String errorMessage = String.format("Operation %s is not supported", operation);
            throw new NotSupportedException(errorMessage);
        }
    }

    private int solveAdd(int operand1, int operand2)
    {
        return operand1 + operand2;
    }

    private int solveSub(int operand1, int operand2)
    {
        return operand1 - operand2;
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
