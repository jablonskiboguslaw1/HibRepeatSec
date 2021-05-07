package pl.bogus.hibernate.modul6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.batch.BatchReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App32BatchDeleteJPQL {


    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    private static Logger logger = LogManager.getLogger();


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        int deleted = entityManager.createQuery(
                "delete from Review r " +
                        "where r.product.id=:id"
        )
                .setParameter("id", 2L)
                .executeUpdate();

        logger.info("It has been deleted "+deleted+ " records");

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
