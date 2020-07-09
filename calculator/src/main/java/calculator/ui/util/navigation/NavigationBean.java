package calculator.ui.util.navigation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class NavigationBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    private void navigateTo(final String to)
    {
        try
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect(to);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void navigateToIndex()
    {
        navigateTo(Pages.getIndexPath());
    }

    public void navigateToTest()
    {
        navigateTo(Pages.getTestPath());
    }

    public void navigationToCalculations()
    {
        navigateTo(Pages.getCalculationsPath());
    }

}
