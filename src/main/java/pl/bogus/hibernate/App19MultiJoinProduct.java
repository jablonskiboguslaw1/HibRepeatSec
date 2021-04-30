package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App19MultiJoinProduct {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Product> query = entityManager.createQuery("Select distinct p from Product p " +
                " left join fetch p.attributes" , Product.class);

        List<Product> resultList = query.getResultList();
        // Set<Category> categories =  new HashSet<>(resultList);
        logger.info("size: " + resultList.size());
        for (Product product1 : resultList) {
            logger.info(product1);
            logger.info(product1.getAttributes());
            logger.info(product1.getReviews());




    }



        entityManager.getTransaction().

    commit();
        entityManager.close();

}


}
