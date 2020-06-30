package calculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class TippGenerator {

	@Inject
	private CalculationService calculationService;

	public List<String> generateTips(final int expected) {
		List<String> tipps = new ArrayList<>();

		final int expectedLength = String.valueOf(expected).length();
		final boolean isOdd = expected % 2 == 1;
		final boolean isPrime = calculationService.isPrime(expected);

		final String first = String.format("Die erste Ziffer ist eine %s", String.valueOf(expected).charAt(0));
		final String last = String.format("Die letzte Ziffer ist eine %s",
				String.valueOf(expected).charAt(expectedLength - 1));
		final String length = String.format("Das Ergebnis ist eine Zahl mit %s Ziffern", expectedLength);
		final String odd = String.format("Das Ergebnis ist eine %s Zahl", isOdd ? "ungerade" : "gerade");
		final String prime = String.format("Das Ergebnis ist %s Primzahl", isPrime ? "eine" : "keine");

		Collections.addAll(tipps, first, last, length, odd, prime);
		Collections.shuffle(tipps);

		return tipps;
	}

}
