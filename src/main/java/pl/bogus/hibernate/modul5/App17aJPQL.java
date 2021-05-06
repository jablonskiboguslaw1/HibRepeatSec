package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.*;
import java.util.List;

public class App17aJPQL {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
      /*  TypedQuery<Product> productsQuery = entityManager.createQuery(
                "select p from Product p where p.id =:id",
                Product.class);
        productsQuery.setParameter("id", 31L);
        try {
            Product product = productsQuery.getSingleResult();
            logger.info(product);
        }catch (NoResultException e){
            logger.error("brak wyników" ,e);
        }
*/
        TypedQuery<Product> productsQuery = entityManager.createQuery(
                "select p from Product p where p.id =:id",
                Product.class);
        productsQuery.setParameter("id", 31L);

        Product product = productsQuery.getResultStream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no data found"));
        logger.info(product);


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
