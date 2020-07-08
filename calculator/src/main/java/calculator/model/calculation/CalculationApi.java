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

    public List<Calculation> findAll()
    {
        return em.createNamedQuery(Calculation.findAll, Calculation.class).getResultList();
    }

}
