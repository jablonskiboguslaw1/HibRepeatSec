package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppH03Update {

    private static Logger logger = LogManager.getLogger(AppH03Update.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 1L);

        product.setName("ProductUpdated2");
       // Product merged = entityManager.merge(product);
        logger.info(product);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
