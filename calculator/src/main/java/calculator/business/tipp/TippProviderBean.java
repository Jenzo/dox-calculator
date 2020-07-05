package calculator.business.tipp;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import calculator.business.calculation.CalculationService;

@Stateful
public class TippProviderBean
{

    @EJB
    private CalculationService calculationService;

    private List<String> tipps = new ArrayList<>();
    private int tippIndex = 0;
    private int tippCount = 0;

    public void generateTipps(final int expected)
    {

        reset();

        final boolean isOdd = expected % 2 == 1;
        final boolean isPrime = calculationService.isPrime(expected);
        boolean isNegative = expected < 0;

        int expectedLength = String.valueOf(expected).length();
        char firstChar = String.valueOf(expected).charAt(0);
        char lastChar = String.valueOf(expected).charAt(expectedLength - 1);

        if(isNegative)
        {
            expectedLength -= 1;
            firstChar = String.valueOf(expected).charAt(1);
            lastChar = String.valueOf(expected).charAt(expectedLength);
        }

        final String first = String.format("Die erste Ziffer ist eine %s", firstChar);
        final String last = String.format("Die letzte Ziffer ist eine %s", lastChar);
        final String length = String.format("Das Ergebnis ist eine Zahl mit %s Ziffern", expectedLength);
        final String odd = String.format("Das Ergebnis ist eine %s Zahl", isOdd ? "ungerade" : "gerade");
        final String prime = String.format("Das Ergebnis ist %s Primzahl", isPrime ? "eine" : "keine");
        final String negative = isNegative ? "Die Zahl ist negativ" : "Die Zahl ist positiv";

        Collections.addAll(tipps, first, last, length, odd, prime, negative);
        Collections.shuffle(tipps);

        tippCount = tipps.size();

    }

    private void reset()
    {
        tippIndex = 0;
        tipps.clear();
    }

    public String getTipp()
    {
        final String tippFormat = "Tipp {0}: {1}";
        String msg = MessageFormat.format(tippFormat, tippIndex + 1, tipps.get(tippIndex));
        tippIndex = ++tippIndex % tippCount;

        return msg;
    }

    public int getTippCount()
    {
        return tippCount;
    }

}
