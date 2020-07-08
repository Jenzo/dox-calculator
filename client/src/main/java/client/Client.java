package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import calculator.ui.webservice.Calculation;
import calculator.ui.webservice.CalculationServiceException_Exception;
import calculator.ui.webservice.WebServiceCalculation;
import calculator.ui.webservice.WebServiceCalculation_Service;

public class Client
{

    private static final Logger LOG = LoggerFactory.getLogger(Client.class);
    private static final boolean CHEATMODE = true;

    public static void main(String[] args)
    {
        final WebServiceCalculation_Service service = new WebServiceCalculation_Service();
        final WebServiceCalculation calculationService = service.getWebServiceCalculationPort();

        Calculation calculationTO = calculationService.getCalculation();

        int operand1 = calculationTO.getOperand1();
        int operand2 = calculationTO.getOperand2();

        String output = String.format("empfangene Aufgabe: %s + %s = ?", operand1, operand2);
        LOG.info(output);

        calculationTO.setUsername("Bernd");
        int result = -1;

        // cheat modus
        if(CHEATMODE)
        {
            int op1 = 12;
            int op2 = 23;
            calculationTO.setOperand1(op1);
            calculationTO.setOperand2(op2);
            result = op1 + op2;
        }
        calculationTO.setUserResult(result);

        output = String.format("eingetragenes Ergebnis: %s", calculationTO.getUserResult());
        LOG.info(output);

        LOG.info("sende und empfange gelöste Aufgabe zurück...");

        try
        {
            calculationTO = calculationService.solveCalculation(calculationTO);
            LOG.info("gelöste Aufgabe empfangen");
        }
        catch(CalculationServiceException_Exception e)
        {
            LOG.error(e.getMessage());
        }

        output = String.format(
                "Vom User %s errechnetes Ergebnis ist %s",
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
