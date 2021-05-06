package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.jpa.QueryHints;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.time.LocalTime.now;


public class App30JPQLUpdate {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int updated = entityManager.createQuery("update Review r SET rating = :rating where " +
                "r.product.id = :id")
                .setParameter("rating" ,11)
                .setParameter("id" , 1L).executeUpdate();
logger.info("updated "+ updated + " objects");
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
