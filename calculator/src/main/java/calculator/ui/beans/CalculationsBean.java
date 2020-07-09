package calculator.ui.beans;

import static calculator.ui.util.StyleConstants.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import calculator.model.calculation.Calculation;
import calculator.model.calculation.CalculationApi;

@Named
@ViewScoped
public class CalculationsBean implements Serializable
{

    private static final long serialVersionUID = 1L;

    @EJB
    private CalculationApi calculationApi;

    private transient List<Calculation> calculations = new ArrayList<>();
    private transient List<String> columnClasses = new ArrayList<>();

    @PostConstruct
    public void onConstruct()
    {
        calculations = calculationApi.findByUsernameNotNull();
        Collections.addAll(
                columnClasses,
                COL_CLASS_CENTER,
                COL_CLASS_CENTER,
                COL_CLASS_CENTER,
                COL_CLASS_CENTER,
                COL_CLASS_CENTER,
                COL_CLASS_CENTER);
    }

    public List<Calculation> getCalculations()
    {
        return calculations;
    }

    public String getColumnClasses()
    {
        final String classes = columnClasses.toString();
        return classes.substring(1, classes.length() - 1);
    }

}
