package pl.bogus.hibernate.modul1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Product;
import pl.bogus.hibernate.entity.ProductType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AppH01Create {

    private static Logger logger = LogManager.getLogger(AppH01Create.class);
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        logger.info("hello!");

        Product product = new Product();
        product.setName("product1");
        product.setDescription("this is product1");
        product.setPrice(new BigDecimal("20.0"));
        product.setProductType(ProductType.REAL);
        product.setCreated(LocalDateTime.now());
        product.setUpdated(LocalDateTime.now());

        entityManager.persist(product);
logger.info(product);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
