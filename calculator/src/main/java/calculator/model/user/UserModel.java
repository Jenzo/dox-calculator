package calculator.model.user;

import java.util.Objects;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@Stateless
public class UserModel
{

    @EJB
    private UserApi userApi;

    public UserApi getUserApi()
    {
        return userApi;
    }

    public User getCurrentUser()
    {
        final HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(
                false);
        final User user = (User)session.getAttribute("user");

        return Objects.requireNonNull(user, "User must not be null");
    }

    public User getUser(final long id)
    {
        return userApi.findUserById(id);
    }

    public User getUserOrNew(final String username)
    {
        final User user = userApi.findByUsername(username);
        if(user == null)
        {
            return UserBuilder.newBuilder().withUsername(username).build();
        }

        return user;
    }

    public User getUserOrPersist(final String username)
    {
        User user = userApi.findByUsername(username);
        if(user == null)
        {
            user = UserBuilder.newBuilder().withUsername(username).build();
            userApi.persist(user);
        }

        return user;
    }

}
