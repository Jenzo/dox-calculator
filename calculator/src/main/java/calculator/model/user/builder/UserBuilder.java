package calculator.model.user.builder;

import java.util.Objects;

import calculator.model.user.entity.User;

public class UserBuilder
{

    private User user = new User();

    private UserBuilder()
    {
    }

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

    public UserBuilder withEmail(final String email)
    {
        user.setEmail(email);
        return this;
    }

    public User build()
    {

        Objects.requireNonNull(user, "user must not be null");
        Objects.requireNonNull(user.getUsername(), "user.username must not be null");

        return user;
    }

    public static UserBuilder newBuilder()
    {
        return new UserBuilder();
    }
}
