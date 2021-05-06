package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class App24QueryWithIn {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Order> orders = entityManager.createQuery("select o from Order o" +
                " where id not in (:ids)", Order.class)
                .setParameter("ids" , Arrays.asList(1L,3L,5L)).getResultList();
        for (Order order : orders) {
            logger.info(order);


        }


        // Order order = entityManager.find(Order.class, 1L);


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
