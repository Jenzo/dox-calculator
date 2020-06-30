package calculator.service;

import javax.ejb.Stateless;

@Stateless
public class CalculationService {

	public CalculationResult solveAdd(final int expected, final int submitted) {

		boolean correct = false;
		final String message;

		if (expected == submitted) {
			correct = true;
			message = createMessage(true);
		} else {
			message = createMessage(false);
		}

		return new CalculationResult(message, correct);
	}

	public boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		boolean isPrime = false;
		for (int i = 2; i <= n / 2; ++i) {
			if (n % i == 0) {
				isPrime = true;
				break;
			}
		}

		return !isPrime;

	}

	private String createMessage(final boolean correct) {

		if (correct) {
			return String.format("Dein Ergebnis ist richtig %s </br> Weiter zur nächsten Aufgabe", getSolvedIcon(true));
		} else {
			return String.format("Das ist leider nicht richtig %s </br>Versuche es nochmal oder hole Dir einen Tipp",
					getSolvedIcon(false));
		}

	}

	private String getSolvedIcon(final boolean correct) {
		return String.format("<i class=\"%s\"></i> ", getIconClass(correct));
	}

	private String getIconClass(final boolean correct) {
		return correct ? "fa fa-smile-o" : "fa fa-meh-o";
	}

}
