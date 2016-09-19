package big.proj.ee.EJB;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Влад on 21.07.2016.
 */
public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "EJB")
    private EntityManager em;

}
