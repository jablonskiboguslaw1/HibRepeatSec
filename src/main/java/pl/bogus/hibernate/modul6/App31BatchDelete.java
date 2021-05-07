package pl.bogus.hibernate.modul6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App31BatchDelete {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<BatchReview> batchReviews = entityManager.createQuery(
                "select r from BatchReview r " +
                        "where r.productId=:id",
                BatchReview.class
        )
                .setParameter("id", 1L)
                .getResultList();

        for (BatchReview batchReview : batchReviews) {
            entityManager.remove(batchReview);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
