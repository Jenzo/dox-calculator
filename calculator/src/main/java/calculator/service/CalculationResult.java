package calculator.service;

public class CalculationResult {

	private final String message;
	private final boolean correctSolved;

	public CalculationResult(final String message, final boolean correctSolved) {
		this.message = message;
		this.correctSolved = correctSolved;
	}

	public String getMessage() {
		return message;
	}

	public boolean isCorrectSolved() {
		return correctSolved;
	}

}
