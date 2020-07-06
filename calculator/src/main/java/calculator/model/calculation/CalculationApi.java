package calculator.model.calculation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CalculationApi
{

    @PersistenceContext
    private EntityManager em;

    public void persist(final Calculation calculation)
    {
        em.persist(calculation);
    }

    public List<Calculation> findAll()
    {
        return em.createNamedQuery(Calculation.findAll, Calculation.class).getResultList();
    }

}
