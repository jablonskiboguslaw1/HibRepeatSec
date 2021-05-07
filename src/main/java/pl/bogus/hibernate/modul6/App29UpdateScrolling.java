package pl.bogus.hibernate.modul6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jpa.QueryHints;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.QueryHint;
import java.util.List;

import static java.time.LocalTime.now;


public class App29UpdateScrolling {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery(
                "select r from BatchReview r",
                BatchReview.class
        )
                .setHint(QueryHints.HINT_FETCH_SIZE, Integer.MAX_VALUE)
                .getResultStream()
                .forEach(batchReview -> {
                    batchReview.setRating(5);
                    batchReview.setContent( now().toString());
                    logger.info(batchReview);
                });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
