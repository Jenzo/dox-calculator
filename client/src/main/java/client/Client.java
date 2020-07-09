package client;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import calculator.business.calculation.webservice.Calculation;
import calculator.business.calculation.webservice.CalculationWebServiceException_Exception;
import calculator.business.calculation.webservice.WebServiceCalculation;
import calculator.business.calculation.webservice.WebServiceCalculation_Service;

public class Client
{

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);
    private static final boolean CHEATMODE = false;

    public static void main(String[] args)
    {
        final WebServiceCalculation_Service service = new WebServiceCalculation_Service();
        final WebServiceCalculation calculationService = service.getWebServiceCalculationPort();

        Calculation calculationTO = calculationService.getCalculation();

        int operand1 = calculationTO.getOperand1();
        int operand2 = calculationTO.getOperand2();

        String output = MessageFormat.format("empfangene Aufgabe: {0} + {1} = ?", operand1, operand2);
        LOG.info(output);

        calculationTO.setUsername("Client");
        int result = -1;

        // cheat modus
        if(CHEATMODE)
        {
            int op1 = 12;
            int op2 = 23;
            calculationTO.setOperand1(op1);
            calculationTO.setOperand2(op2);
            result = op1 + op2;
            LOG.info("Cheatmodus an. Neue Aufgabe {} + {} = {}", op1, op2, result);
        }
        calculationTO.setUserResult(result);

        output = String.format("eingetragenes Ergebnis: %s", calculationTO.getUserResult());
        LOG.info(output);

        LOG.info("sende und empfange gelöste Aufgabe...");

        try
        {
            calculationTO = calculationService.solveCalculation(calculationTO);
            LOG.info("gelöste Aufgabe empfangen");
        }
        catch(CalculationWebServiceException_Exception e)
        {
            LOG.error("Fehler bei Einreichung. Grund: {}", e.getMessage());
        }

        output = MessageFormat.format(
                "Vom User {0} errechnetes Ergebnis ist {1}",
                calculationTO.getUsername(),
                calculationTO.isCorrectSolved() ? "richtig" : "falsch");

        if(calculationTO.isCorrectSolved())
        {
            LOG.info(output);
        }
        else
        {
            LOG.warn(output);
        }
    }

}
