package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App27Batching {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.unwrap(Session.class).setJdbcBatchSize(10);
        entityManager.getTransaction().begin();

        Long lastId = (Long) entityManager.createQuery("select max(r.id) from BatchReview r").getSingleResult();

        for (long i = 1; i <= 25; i++) {

            if (i % 5 == 0) {
                entityManager.flush();
                entityManager.clear();
            }
            entityManager.persist(new BatchReview(lastId + i, "Content " + i, 5, 1L));

        }


        entityManager.getTransaction().commit();
        entityManager.close();


    }

}
