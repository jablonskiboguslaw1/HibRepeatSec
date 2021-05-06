package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App17JPQLAggrGroup {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "select p.category.id, Count(p) from Product p " +
                        "group by p.category" );
// query.setParameter("id", 6L);
        List<Object[]> resultList = query.getResultList();
        for (Object[] array : resultList) {
            logger.info(array[0] +", "+ array[1]);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
