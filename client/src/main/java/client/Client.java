package client;

import calculator.ui.webservice.Calculation;
import calculator.ui.webservice.CalculationServiceException_Exception;
import calculator.ui.webservice.WebServiceCalculation;
import calculator.ui.webservice.WebServiceCalculation_Service;

public class Client
{

    public static void main(String[] args)
    {
        final WebServiceCalculation_Service service = new WebServiceCalculation_Service();
        final WebServiceCalculation calculationService = service.getWebServiceCalculationPort();

        Calculation calculationTO = calculationService.getCalculation();

        int operand1 = calculationTO.getOperand1();
        int operand2 = calculationTO.getOperand2();

        String output = String.format("empfangene Aufgabe: %s + %s = ?", operand1, operand2);
        System.out.println(output);

        calculationTO.setUsername("Bernd");
        int result = operand1 + operand2;

        calculationTO.setUserResult(result);

//        calculationTO.setOperand1(12);

        output = String.format("eingetragenes Ergebnis: %s", calculationTO.getUserResult());
        System.out.println(output);

        System.out.println("sende und empfange gelöste Aufgabe zurück...");

        try
        {
            calculationTO = calculationService.solveCalculation(calculationTO);
            System.out.println("gelöste Aufgabe empfangen");
        }
        catch(CalculationServiceException_Exception e)
        {
            System.err.println(e.getMessage() + "\n");
        }

        output = String.format(
                "Vom User %s errechnetes Ergebnis ist %s",
                calculationTO.getUsername(),
                calculationTO.isCorrectSolved() ? "richtig" : "falsch");

        System.out.println(output);

    }

}