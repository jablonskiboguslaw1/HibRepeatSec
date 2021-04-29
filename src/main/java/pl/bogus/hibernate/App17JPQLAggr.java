package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.*;
import java.util.List;

public class App17JPQLAggr {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "select Count(p),AVG(p.price) from Product p" );
// query.setParameter("id", 6L);
        Object[] result = (Object[]) query.getSingleResult();


        logger.info(result[0]);
        logger.info(result[1]);


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
