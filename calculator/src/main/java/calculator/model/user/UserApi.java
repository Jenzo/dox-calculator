package calculator.model.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserApi
{

    @PersistenceContext
    private EntityManager em;

    public void persist(final User user)
    {
        em.persist(user);
    }

    public void merge(final User user)
    {
        em.merge(user);
    }

    public List<User> findAll()
    {
        return em.createNamedQuery(User.findAll, User.class).getResultList();
    }

    public User findUserById(final long id)
    {
        List<User> users = em.createNamedQuery(User.findById, User.class).setParameter("userId", id).getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public User findByUsername(final String username)
    {
        List<User> users = em.createNamedQuery(User.findByUsername, User.class).setParameter(
                "username",
                username).getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

}
