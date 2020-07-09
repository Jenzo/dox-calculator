package calculator.model.calculation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CalculationApi
{

    private static final Logger LOG = LoggerFactory.getLogger(CalculationApi.class);

    @PersistenceContext
    private EntityManager em;

    public void persist(final Calculation calculation)
    {
        em.persist(calculation);
        LOG.info("Objekt persistiert {}", calculation);
    }

    public void merge(final Calculation calculation)
    {
        em.merge(calculation);
        LOG.info("Objekt gemerged {}", calculation);
    }

    public void remove(final Calculation calculation)
    {
        em.remove(em.contains(calculation) ? calculation : em.merge(calculation));
        LOG.info("Objekt gelöscht {}", calculation);
    }

    public Calculation findById(final long id)
    {
        List<Calculation> calculations = em.createNamedQuery(Calculation.findById, Calculation.class).setParameter(
                "id",
                id).getResultList();
        return calculations.isEmpty() ? null : calculations.get(0);
    }

    public List<Calculation> findByUsernameNotNull()
    {
        return em.createNamedQuery(Calculation.findByUsernameNotNull, Calculation.class).getResultList();
    }

    public List<Calculation> findAll()
    {
        return em.createNamedQuery(Calculation.findAll, Calculation.class).getResultList();
    }

}
