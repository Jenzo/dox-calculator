package calculator.model.user;

import java.util.Objects;

public class UserBuilder
{
    public static UserBuilder newBuilder()
    {
        return new UserBuilder();
    }

    private UserBuilder()
    {
    }

    private User user = new User();


    public UserBuilder withUsername(final String username)
    {
        user.setUsername(username);
        return this;
    }

    public UserBuilder withSolved(final boolean solved)
    {
        user.setSolved(solved);
        return this;
    }

    public User build()
    {

        Objects.requireNonNull(user, "user must not be null");
        Objects.requireNonNull(user.getUsername(), "user.username must not be null");

        return user;
    }

}
