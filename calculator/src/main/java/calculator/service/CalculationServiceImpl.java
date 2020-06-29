package calculator.service;

public class CalculationServiceImpl implements CalculationService {

	@Override
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

}
