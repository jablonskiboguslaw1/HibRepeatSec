package pl.bogus.hibernate.modul2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App09OneToOneBidirectional {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Category category = entityManager.find(Category.class, 1L);
        logger.info(category);
        logger.info(category.getProduct());


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
