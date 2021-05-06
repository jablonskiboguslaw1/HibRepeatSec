package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Order;
import pl.bogus.hibernate.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App23FetchMode {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Order> orders = entityManager.createQuery("select o from Order o", Order.class).getResultList();
        for (Order order : orders) {
            logger.info(order);
            logger.info(order.getOrderRows());

        }


        // Order order = entityManager.find(Order.class, 1L);


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
