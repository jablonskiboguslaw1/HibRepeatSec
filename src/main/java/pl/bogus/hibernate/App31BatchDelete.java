package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App31BatchDelete {


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
