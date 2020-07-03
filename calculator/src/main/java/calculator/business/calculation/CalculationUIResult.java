package calculator.business.calculation;

public class CalculationUIResult {

	private final String message;
	private final boolean correctSolved;

	public CalculationUIResult(final String message, final boolean correctSolved) {
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
