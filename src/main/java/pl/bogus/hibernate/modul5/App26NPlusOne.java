package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Order;
import pl.bogus.hibernate.entity.OrderRow;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App26NPlusOne {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

     /*   List<Order> orders = entityManager.createQuery(
                "select distinct o from Order o" +
                        " inner join fetch o.orderRows",
                Order.class)
                .getResultList();
        logger.info("Orders list" + orders.size());
        for (Order order : orders) {
            logger.info(order);
            logger.info(order.getOrderRows());

        }*/

        EntityGraph entityGraph = entityManager.getEntityGraph("order-and-rows");
        List<Order> orders = entityManager.createQuery(
                "select o from Order o",
                Order.class).setHint("javax.persistence.fetchgraph",entityGraph)
                .getResultList();
        logger.info("Orders list" + orders.size());
        for (Order order : orders) {
            logger.info(order);
            logger.info(order.getOrderRows());

        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
