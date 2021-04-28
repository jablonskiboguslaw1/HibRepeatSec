package pl.bogus.hibernate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App10ManyToMany {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 5L);
        logger.info(product);
        for (Attribute attribute : product.getAttributes()) {
            logger.info(attribute);
        }

        logger.info("========================");

        Attribute attribute = entityManager.find(Attribute.class, 2L);
        logger.info(attribute);
        for (Product attributeProduct : attribute.getProducts()) {
            logger.info(attributeProduct);
        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
