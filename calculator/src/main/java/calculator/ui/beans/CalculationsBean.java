package calculator.ui.beans;

import java.io.Serializable;
import java.util.ArrayList;
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

    @PostConstruct
    public void onConstruct()
    {
        calculations = calculationApi.findAll();
    }

    public List<Calculation> getCalculations()
    {
        return calculations;
    }

}
