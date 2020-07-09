package calculator.business.calculation.webservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.ejb.Stateful;

import calculator.model.calculation.Calculation;

@Stateful
public class CalculationGuard
{

    private Map<UUID, Calculation> cache = new HashMap<>();

    public boolean isValid(final Calculation received)
    {
        final Calculation found = cache.get(received.getUuid());
        if(found == null)
        {
            return false;
        }
        cache.remove(received.getUuid());

        return found.getOperand1() == received.getOperand1() && found.getOperand2() == received.getOperand2();

    }

    public void setCreated(final Calculation created)
    {
        this.cache.put(created.getUuid(), created);
    }

}
