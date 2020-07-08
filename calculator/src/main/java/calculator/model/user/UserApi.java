package calculator.model.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class UserApi
{
    
    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);

    @PersistenceContext
    private EntityManager em;

    public void persist(final User user)
    {
        em.persist(user);
        LOG.info("Objekt persistiert: {}", user);
        
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
