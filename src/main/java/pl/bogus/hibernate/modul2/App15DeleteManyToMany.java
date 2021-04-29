package pl.bogus.hibernate.modul2;


import jdk.jshell.spi.SPIResolutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class App15DeleteManyToMany {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Product product = entityManager.find(Product.class, 5L);
        //entityManager.remove(product);
        // product.getAttributes().clear();
        Attribute attribute = entityManager.find(Attribute.class, 1L);
        for (Product product : new ArrayList<>(attribute.getProducts())) {
            attribute.removeProduct(product);
        }
        entityManager.remove(attribute);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
