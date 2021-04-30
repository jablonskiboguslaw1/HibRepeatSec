package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.QueryHints;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App20MultiJoinCartesianAvoid {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


        List<Product> resultList = entityManager.createQuery(
                "select distinct p from Product p " +
                        "left join fetch p.attributes",
                Product.class).setHint(QueryHints.PASS_DISTINCT_THROUGH,false).getResultList();

        resultList = entityManager.createQuery(
                "select distinct p from Product p " +
                        "left join fetch p.reviews",
                Product.class).setHint(QueryHints.PASS_DISTINCT_THROUGH,false).getResultList();


        logger.info("size: "+ resultList.size());
        for (Product product : resultList) {
            logger.info(product);
            logger.info(product.getAttributes());
            logger.info(product.getReviews());
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
