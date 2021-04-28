package pl.bogus.hibernate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App12AddManyToMany {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Attribute attribute = new Attribute();
        attribute.setName("SIZE");
        attribute.setValue("XS");
        Product product = entityManager.find(Product.class, 4L);
       product.addAttribute(attribute);

       logger.info(attribute);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
