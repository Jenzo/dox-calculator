package navigation;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import login.LoginBean;

@Named
@ViewScoped
public class NavigationBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private LoginBean login;

    public void navigateTo(final String to)
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

    public String logout()
    {
        return login.logout();
    }

}
