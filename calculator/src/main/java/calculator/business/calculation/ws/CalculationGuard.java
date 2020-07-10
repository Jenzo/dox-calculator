package calculator.business.calculation.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;

@Stateless
public class CalculationGuard
{
    private Logger LOG = LoggerFactory.getLogger(CalculationGuard.class);

    
    Calculation created;
    Calculation received;
    
    @EJB
    private CalculationApi calculationApi;

    /**
     *  lookup for received Calculation in DB <br>
     *  if not found -> was not persisted prior <br>
     *  if has sumbmittedAt date -> was send and solved prior -> don't solve and merge again 
     *  <br><br>
     *  if found and received operands are not equal -> received Calculation could be changed by Client. 
     *  If Calculation operands were changed by Client -> remove prior persisted Calculation from DB to prevent submitting 
     *  same Calculation with right operands and right result again.
     *  
     * @param received Calculation from SOAP-Client
     * @throws CalculationWebServiceException
     */
    public void validate(final Calculation received) throws CalculationWebServiceException
    {
        final Calculation found = calculationApi.findById(received.getId());
        if(found == null)
        {
            String msg = "Fehler. ID nicht gefunden";
            LOG.error(msg);
            throw new CalculationWebServiceException(msg);
        }

        
        if(found.getSubmittedAt() != null)
        {
            String msg = "Fehler. Doppelte Einreichung mit der gleicher ID nicht möglich";
            LOG.error(msg);
            throw new CalculationWebServiceException(msg);
        }

        boolean sameOperands = found.getOperand1() == received.getOperand1()
                && found.getOperand2() == received.getOperand2();

        if(!sameOperands)
        {

            String msg = "Möglicher Täuschungsversuch!! Die Operanden sind unterschiedlich.";
            calculationApi.remove(received);
            LOG.warn(msg);
            throw new CalculationWebServiceException(msg);
        }

    }

}
