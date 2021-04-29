package pl.bogus.hibernate.modul2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App11AddOneToOne {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        Category category = new Category();
        category.setName("the best category");
        category.setDescription("the best category description");
        entityManager.persist(category);
        product.setCategory(category);

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
