package calculator.model.user;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserModel
{

    @EJB
    private UserApi userApi;

    public UserApi getUserApi()
    {
        return userApi;
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

}
