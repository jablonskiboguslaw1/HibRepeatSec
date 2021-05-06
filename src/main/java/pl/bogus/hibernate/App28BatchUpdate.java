package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App28BatchUpdate {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int batchSize = 10;
        entityManager.unwrap(Session.class).setJdbcBatchSize(batchSize);
        Long count = entityManager.createQuery("select count(r) from BatchReview r", Long.class).getSingleResult();

        for (int i = 0; i < count; i = i + batchSize) {

            List<BatchReview> reviews = entityManager.createQuery("select r from BatchReview r", BatchReview.class)
                    .setFirstResult(i)
                    .setMaxResults(batchSize)
                    .getResultList();
            logger.info(reviews);
            for (BatchReview review : reviews) {
                review.setContent("new content - batch number " + i/batchSize);
                review.setRating(13);
            }
            entityManager.flush();
            entityManager.clear();
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
