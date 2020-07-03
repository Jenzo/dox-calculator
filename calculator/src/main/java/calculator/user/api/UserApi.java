package calculator.user.api;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import calculator.user.model.User;

@Stateless
public class UserApi
{

    @PersistenceContext
    private EntityManager em;

    public void persist(final User user)
    {
        em.persist(user);
    }

    public User findUserById(final long id)
    {
        return em.createNamedQuery(User.findById, User.class).setParameter("userId", id).getSingleResult();
    }

    public List<User> findAll()
    {
        return em.createNamedQuery(User.findAll, User.class).getResultList();
    }

    public List<User> findUsersBySolved(final boolean solved)
    {
        return em.createNamedQuery(User.findAllBySolved, User.class).setParameter("solved", solved).getResultList();
    }
}
