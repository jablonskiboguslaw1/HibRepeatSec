package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App17JPQL {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Product> productsQuery = entityManager.createQuery(
                "select p from Product p where p.id =:id",
                Product.class);
        productsQuery.setParameter("id", 3L);
        List<Product> products = productsQuery.getResultList();

        //List<Product> products = entityManager.createQuery("select p from Product p").getResultList();
        for (Product product : products) {
            logger.info(product);
        }




        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
