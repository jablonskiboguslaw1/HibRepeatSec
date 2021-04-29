package pl.bogus.hibernate.modul2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Category;
import pl.bogus.hibernate.entity.Product;
import pl.bogus.hibernate.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App14DeleteOneToOne {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, 3L);
        Category category = product.getCategory();
        if (category.getProduct().size()==1 )
        {
            entityManager.remove(category);
            product.setCategory(null);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
