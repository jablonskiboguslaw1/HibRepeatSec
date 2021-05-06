package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App19MultiJoin {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Category> query = entityManager.createQuery("Select c from Category c " +
                " left join fetch c.product p" +
                " left join fetch p.reviews " +
                "where c.id = :id",Category.class);
        query.setParameter("id", 1L);
        List<Category> resultList = query.getResultList();
       // Set<Category> categories =  new HashSet<>(resultList);
        logger.info("size: "+ resultList.size());
        for (Category category : resultList) {
            logger.info(category);
            logger.info(category.getProduct());
            for (Product product : category.getProduct()) {
                logger.info(product.getReviews());
            } {

            }

        }



        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
