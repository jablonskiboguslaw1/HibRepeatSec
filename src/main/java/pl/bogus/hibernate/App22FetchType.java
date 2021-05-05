package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App22FetchType {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

       /* Product product = entityManager.createQuery("select p from Product p where p.id=:id", Product.class)
                .setParameter("id", 1L)
                .getSingleResult();*/

        Product product = entityManager.find(Product.class, 1L);


        logger.info(product);
        logger.info(product.getCategory());
        logger.info(product.getReviews());

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
