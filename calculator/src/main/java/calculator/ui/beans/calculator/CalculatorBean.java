package calculator.ui.beans.calculator;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import calculator.business.calculation.CalculationRequest;
import calculator.business.calculation.CalculationUIResult;
import calculator.business.calculation.CalculationService;
import calculator.business.calculation.Operation;
import calculator.business.tipp.TippGenerator;
import calculator.model.user.User;
import calculator.model.user.UserModel;
import calculator.ui.messages.Messages;

@Named
@ViewScoped
public class CalculatorBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    /* INJECTS */

    @EJB
    private UserModel model;

    @EJB
    private CalculationService calculationService;

    @EJB
    private TippGenerator tippGenerator;

    /* RANDS */
    private int rand1;
    private int rand2;
    private int result;
    private Random random = new Random();
    private static final int BOUNDARY = 75;

    /* TIPPS */
    private boolean showTipps;
    private String tip;

    /* SOLVE STATS */
    private boolean solved;
    private int solvedCounter = 0;
    private int solvedCounterWithTipps = 0;

    /* USER */
    private String username;
    private List<User> users = new ArrayList<>();
    private boolean showUsers;
    private User bestUser;

    /* INIT */
    @PostConstruct
    public void onConstruct()
    {
        resetView();
    }

    /*
     * VIEW RESETS
     */

    private void resetView()
    {
        setShowTipps(false);
        resetRands();
        resetTipps();
        resetUser();
    }

    private void resetTipps()
    {
        tip = "";
        tippGenerator.generateTipps(getExpectedResult());

    }

    private void resetRands()
    {
        result = 0;
        rand1 = random.nextInt(BOUNDARY);
        rand2 = random.nextInt(BOUNDARY);
        solved = false;
    }

    private void resetUser()
    {
        users = model.getUserApi().findAll();
        bestUser = model.getUserApi().findByMostCorrectAnswered();
    }

    /*
     * ACTIONS
     */

    public void onSubmit()
    {

        final User user = model.getUserOrNew(username);
        final CalculationUIResult calculationResult = calculationService.solve(
                new CalculationRequest(rand1, rand2, Operation.ADD),
                result);
        final String msg = MessageFormat.format(calculationResult.getMessage(), user.getUsername());

        if(calculationResult.isCorrectSolved())
        {
            solved = true;
            user.setCorrectAnswers(user.getCorrectAnswers() + 1);

            Messages.success("input_result", msg);
        }
        else
        {
            solved = false;
            Messages.error("input_result", msg);
        }

        user.setSolved(solved);
        model.getUserApi().merge(user);

        resetUser();
        setShowTipps(false);

    }

    public void onGetTipp()
    {
        setShowTipps(true);

        tip = tippGenerator.getTipp();
    }

    public void onGetNext()
    {
        resetView();
    }

    public void onShowUsers()
    {
        setShowUsers(!showUsers);
    }

    /*
     * GETTER AND SETTER
     */

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getTipp()
    {

        if(!isShowTipps())
        {
            return "";
        }

        return tip;
    }

    public String getCalculation()
    {
        return String.format("%d %s %d = ", rand1, "+", rand2);
    }

    private int getExpectedResult()
    {
        return rand1 + rand2;
    }

    public int getRand1()
    {
        return rand1;
    }

    public void setRand1(int rand1)
    {
        this.rand1 = rand1;
    }

    public int getRand2()
    {
        return rand2;
    }

    public void setRand2(int rand2)
    {
        this.rand2 = rand2;
    }

    public int getResult()
    {
        return result;
    }

    public void setResult(int result)
    {
        this.result = result;
    }

    public boolean isShowTipps()
    {
        return showTipps;
    }

    public int getSolvedCounter()
    {
        return solvedCounter;
    }

    public int getSolvedCounterWithTipps()
    {
        return solvedCounterWithTipps;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public boolean isShowUsers()
    {
        return showUsers;
    }

    public void setShowUsers(boolean showUsers)
    {
        this.showUsers = showUsers;
    }

    public boolean isSolved()
    {
        return solved;
    }

    public void setShowTipps(boolean showTipps)
    {
        this.showTipps = showTipps;
    }

    public User getBestUser()
    {
        return bestUser;
    }

}
