package calculator.ui.beans;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import calculator.business.calculation.CalculationProviderBean;
import calculator.business.calculation.CalculationService;
import calculator.business.tipp.TippProviderBean;
import calculator.model.calculation.Calculation;
import calculator.model.user.User;
import calculator.model.user.UserBuilder;
import calculator.model.user.UserModel;
import calculator.ui.messages.Icons;
import calculator.ui.messages.Messages;

@Named
@ViewScoped
public class TestBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    /* CALCULATION */
    @EJB
    private CalculationProviderBean calculationProvider;

    @EJB
    private CalculationService calculationService;

    private Calculation calculation;
    private boolean solved;

    /* TIPPS */
    @EJB
    private TippProviderBean tippProvider;
    private boolean showTipps;
    private String tip;

    /* USER */
    @EJB
    private UserModel model;
    private List<User> users = new ArrayList<>();
    private boolean showUsers;

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
        resetCalculation();
        resetTipps();
        resetUser();
    }

    private void resetTipps()
    {
        tip = null;
        tippProvider.generateTipps(calculation.getOperand1() + calculation.getOperand2());

    }

    private void resetCalculation()
    {
        calculation = calculationProvider.createNewCalculation(100);
        solved = false;
    }

    private void resetUser()
    {
        users = model.getUserApi().findAll();
    }

    /*
     * ACTIONS
     */

    public void onSubmit()
    {
        final boolean correctSolved = calculationService.solve(calculation).isCorrectSolved();
        final String msg = MessageFormat.format(createSolvedMessage(correctSolved), calculation.getUsername());

        if(correctSolved)
        {
            solved = true;
            Messages.success("input_result", msg);
        }
        else
        {
            solved = false;
            Messages.error("input_result", msg);
        }

        final User user = UserBuilder.newBuilder().withUsername(calculation.getUsername()).build();
        model.getUserApi().persist(user);

        resetUser();
        setShowTipps(false);

    }

    public void onGetTipp()
    {
        setShowTipps(true);

        tip = tippProvider.getTipp();
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

    public String getTipp()
    {

        if(!isShowTipps())
        {
            return "";
        }

        return tip;
    }

    public String getCalculationString()
    {
        return calculation.getCalculationString();
    }

    public boolean isShowTipps()
    {
        return showTipps;
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

    private String createSolvedMessage(final boolean correct)
    {

        if(correct)
        {
            return String.format(
                    "Dein Ergebnis ist richtig {0} %s </br> Weiter zur nächsten Aufgabe",
                    Icons.getSmileO());
        }
        else
        {
            return String.format(
                    "Das ist leider nicht richtig {0} %s </br>Versuche es nochmal oder hole Dir einen Tipp",
                    Icons.getMehO());
        }

    }

    public void setCalculation(Calculation calculation)
    {
        this.calculation = calculation;
    }

    public Calculation getCalculation()
    {
        return calculation;
    }

}
