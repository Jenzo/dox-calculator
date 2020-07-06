package calculator.ui.webservice;

import javax.ejb.Stateful;

import calculator.model.calculation.Calculation;

@Stateful
public class CalculationGuard
{

    private Calculation created;
    private Calculation received;

    public boolean areEqual()
    {
        return created.getOperand1() == received.getOperand1() && created.getOperand2() == received.getOperand2();
    }

    public void setCreated(Calculation created)
    {
        this.created = created;
    }

    public void setReceived(Calculation received)
    {
        this.received = received;
    }

}
