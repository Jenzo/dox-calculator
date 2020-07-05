package calculator.ui.beans.calculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import calculator.business.task.TaskProviderBean;
import calculator.business.tipp.TippProviderBean;
import calculator.model.task.Task;
import calculator.model.user.User;
import calculator.model.user.UserModel;
import calculator.ui.messages.Icons;
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
    private TippProviderBean tippProvider;

    @EJB
    private TaskProviderBean taskProvider;

    /* TASK */
    private transient Task task;
    private BigDecimal userResult;

    /* TIPPS */
    private boolean showTipps;
    private String tip;

    /* SOLVE STATS */
    private boolean solved;

    /* USER */
    private String username;
    private List<User> users = new ArrayList<>();
    private boolean showUsers;
    private User bestUser;

    private User currentUser;

    /* INIT */
    @PostConstruct
    public void onConstruct()
    {
        currentUser = model.getCurrentUser();
        username = currentUser.getUsername();
        resetView();
    }

    /*
     * VIEW RESETS
     */

    private void resetView()
    {
        setShowTipps(false);
        resetTask();
        resetTipps();
        resetUser();
    }

    private void resetTipps()
    {
        tip = "";
        tippProvider.generateTipps(task.getCalculation().getResult().intValue());

    }

    private void resetTask()
    {
        userResult = new BigDecimal(0);
        solved = false;
        task = taskProvider.createTask();
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

        final boolean correctSolved = task.isCorrectSolved(userResult);
        final String msg = MessageFormat.format(createSolvedMessage(correctSolved), currentUser.getUsername());

        if(correctSolved)
        {
            solved = true;
            currentUser.setCorrectAnswers(currentUser.getCorrectAnswers() + 1);

            Messages.success("input_result", msg);
        }
        else
        {
            solved = false;
            Messages.error("input_result", msg);
        }

        currentUser.setSolved(solved);
        model.getUserApi().merge(currentUser);

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
        return task.getCalculation().toString();
    }

    public Number getUserResult()
    {
        return userResult;
    }

    public void setUserResult(final BigDecimal userResult)
    {
        this.userResult = userResult;
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

    public User getBestUser()
    {
        return bestUser;
    }

    public User getCurrentUser()
    {
        return currentUser;
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

}
