package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;
import pl.bogus.hibernate.entity.ProductInCategoryCounterDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class App18Join {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Product> query = entityManager.createQuery("Select p from Product p " +
                "left join  fetch p.category c ",/*+
                "where c.id =:id",*/ Product.class);
        //query.setParameter("id", 2L);
        List<Product> resultList = query.getResultList();
        for (Product product : resultList) {
            logger.info(product);
            logger.info(product.getCategory());
        }



        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
