package calculator.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
@Local(TippGenerator.class)
public class TippGeneratorBean implements TippGenerator
{

    @Inject
    private CalculationService calculationService;

    private List<String> tipps = new ArrayList<>();
    private int tippIndex = 0;
    private int tippCount = 0;

    @Override
    public void generateTipps(final int expected)
    {

        reset();

        final int expectedLength = String.valueOf(expected).length();
        final boolean isOdd = expected % 2 == 1;
        final boolean isPrime = calculationService.isPrime(expected);

        final String first = String.format("Die erste Ziffer ist eine %s", String.valueOf(expected).charAt(0));
        final String last = String.format(
                "Die letzte Ziffer ist eine %s",
                String.valueOf(expected).charAt(expectedLength - 1));
        final String length = String.format("Das Ergebnis ist eine Zahl mit %s Ziffern", expectedLength);
        final String odd = String.format("Das Ergebnis ist eine %s Zahl", isOdd ? "ungerade" : "gerade");
        final String prime = String.format("Das Ergebnis ist %s Primzahl", isPrime ? "eine" : "keine");

        Collections.addAll(tipps, first, last, length, odd, prime);
        Collections.shuffle(tipps);

        tippCount = tipps.size();

    }

    private void reset()
    {
        tippIndex = 0;
        tipps.clear();
    }

    @Override
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
