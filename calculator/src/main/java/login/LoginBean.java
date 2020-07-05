package login;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import calculator.model.user.User;
import calculator.model.user.UserModel;
import navigation.NavigationBean;

@Named()
@ViewScoped
public class LoginBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private NavigationBean navigationBean;

    @EJB
    private UserModel model;

    private String username;

    public void login()
    {
        final User user = model.getUserOrPersist(username);

        final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.getSessionMap().put("user", user);

        if(context.getSessionMap().containsKey("from"))
        {
            String from = (String)context.getSessionMap().get("from");
            navigationBean.navigateTo(from);
        }
        else
        {
            navigationBean.navigateToIndex();
        }

    }

    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login.xhtml?faces-redirect=true";
    }

    public String getUserName()
    {
        return username;
    }

    public void setUserName(String username)
    {
        this.username = username;
    }
}
