package calculator.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import calculator.service.CalculationResult;
import calculator.service.CalculationService;
import calculator.service.MessageProducer;
import calculator.service.TippGenerator;

@Named
@ViewScoped
public class CaluculatorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/* INJECTS */
	@Inject
	private TippGenerator tippGenerator;

	@Inject
	private CalculationService calculationService;

	/* RANDS */
	private int rand1;
	private int rand2;
	private int result;
	private Random random = new Random();
	private static final int BOUNDARY = 1000;

	/* TIPPS */
	private int tippIndex;
	private boolean showTips;
	private List<String> tipps = new ArrayList<>();
	private StringJoiner tipJoiner = new StringJoiner("</br>");
	private boolean tippRequested;

	private boolean solved;
	private int solvedCounter = 0;
	private int solvedCounterWithTipps = 0;

	/* INIT */
	@PostConstruct
	public void onConstruct() {
		resetView();
	}

	/*
	 * VIEW RESETS
	 */

	private void resetView() {
		setShowTips(false);
		resetRands();
		resetTipps();
	}

	private void resetTipps() {
		tipps.clear();
		tippIndex = 0;
		tipJoiner = new StringJoiner("</br>");
		generateTipps();
		tippRequested = false;

	}

	private void resetRands() {
		result = 0;
		rand1 = random.nextInt(BOUNDARY);
		rand2 = random.nextInt(BOUNDARY);
		solved = false;
	}

	private void generateTipps() {
		tipps = tippGenerator.generateTips(getExpectedResult());
	}

	/*
	 * ACTIONS
	 */

	public void onSubmit() {

		final CalculationResult response = calculationService.solveAdd(getExpectedResult(), getResult());

		if (response.isCorrectSolved()) {
			solved = true;

			solvedCounter++;
			if (tippRequested) {
				solvedCounterWithTipps++;
			}

			MessageProducer.success(response.getMessage());

		} else {
			solved = false;
			MessageProducer.error(response.getMessage());
		}

	}

	public void onGetTipp() {
		setShowTips(true);
		tippRequested = true;

		if (tippIndex < tipps.size()) {
			final String tip = String.format("Tipp %d: %s", (tippIndex + 1), tipps.get(tippIndex));
			tipJoiner.add(tip);
			tippIndex++;
		}
	}

	public void onGetNext() {
		resetView();
	}

	/*
	 * GETTER AND SETTER
	 */

	public String getTipp() {

		if (!isShowTipps()) {
			return "";
		}

		return tipJoiner.toString();
	}

	public String getCalculation() {
		return String.format("%d %s %d = ", rand1, "+", rand2);
	}

	private int getExpectedResult() {
		return rand1 + rand2;
	}

	public int getRand1() {
		return rand1;
	}

	public void setRand1(int rand1) {
		this.rand1 = rand1;
	}

	public int getRand2() {
		return rand2;
	}

	public void setRand2(int rand2) {
		this.rand2 = rand2;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean isShowTipps() {
		return showTips;
	}

	public void setShowTips(boolean showTips) {
		this.showTips = showTips;
	}

	public boolean isBtnGetTippsDisabled() {
		return this.tippIndex >= tipps.size() || solved;
	}

	public boolean isBtnSubmitDisabled() {
		return solved;
	}

	public int getSolvedCounter() {
		return solvedCounter;
	}

	public int getSolvedCounterWithTipps() {
		return solvedCounterWithTipps;
	}

}
