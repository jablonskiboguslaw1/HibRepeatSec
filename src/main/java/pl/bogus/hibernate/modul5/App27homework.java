package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Order;
import pl.bogus.hibernate.entity.Product;
import pl.bogus.hibernate.entity.Review;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App27homework {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        EntityGraph entityGraph = entityManager.getEntityGraph("prod-rew-attr");

      List<Product> products = entityManager.createQuery("select p from Product p",Product.class)
              .setHint("javax.persistence.fetchgraph",entityGraph).getResultList();

      logger.info(products.size());
        for (Product product1 : products) {
         logger.info(product1);
         /*      for (Review review : (product1.getReviews())) {
                logger.info(review);
            }
            for (Attribute attribute : product1.getAttributes()) {
                logger.info(attribute);
            }*/


        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
