package calculator.model.calculation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name = "Calculation.findAll", query = "SELECT c FROM Calculation c")
@Entity
public class Calculation
{

    public static final String findAll = "Calculation.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int operand1;

    private int operand2;

    @Column(nullable = false)
    private int userResult;

    @Column(nullable = false)
    private String username;

    private boolean correctSolved;

    private Date submittedAt;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public int getOperand1()
    {
        return operand1;
    }

    public void setOperand1(int operand1)
    {
        this.operand1 = operand1;
    }

    public int getOperand2()
    {
        return operand2;
    }

    public void setOperand2(int operand2)
    {
        this.operand2 = operand2;
    }

    public int getUserResult()
    {
        return userResult;
    }

    public void setUserResult(int userResult)
    {
        this.userResult = userResult;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getCalculationString()
    {
        return String.format("%s %s %s = ", operand1, Operation.ADD.getSymbol(), operand2);
    }

    public boolean isCorrectSolved()
    {
        return correctSolved;
    }

    public void setCorrectSolved(boolean correctSolved)
    {
        this.correctSolved = correctSolved;
    }

    public Date getSubmittedAt()
    {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt)
    {
        this.submittedAt = submittedAt;
    }

    @Override
    public String toString()
    {
        return "Calculation [id="
                + id
                + ", operand1="
                + operand1
                + ", operand2="
                + operand2
                + ", userResult="
                + userResult
                + ", username="
                + username
                + ", correctSolved="
                + correctSolved
                + ", submittedAt="
                + submittedAt
                + "]";
    }
}
