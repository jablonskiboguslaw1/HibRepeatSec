package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Order;
import pl.bogus.hibernate.entity.OrderRow;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App25EntityGraph {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        /*EntityGraph entityGraph = entityManager.getEntityGraph("order-rows");
        Map<String, Object> map = new HashMap<>();
        map.put("javax.persistence.fetchgraph", entityGraph);
        Order order = entityManager.find(Order.class, 1L, map);
        logger.info(order);
        logger.info(order.getOrderRows());
        for (OrderRow orderRow : order.getOrderRows()) {
            logger.info(orderRow);
            logger.info(orderRow.getProduct());
        }
*/

        EntityGraph entityGraph = entityManager.createEntityGraph(Order.class);
        entityGraph.addAttributeNodes("orderRows");
        entityGraph.addAttributeNodes("customer");
        Subgraph<OrderRow> orderRows = entityGraph.addSubgraph("orderRows");
        orderRows.addAttributeNodes("product");


        List<Order> orders = entityManager.createQuery("select o from Order o", Order.class)
                .setHint("javax.persistence.fetchgraph", entityGraph)
                .getResultList();
        for (Order order : orders) {
            logger.info(order);
            logger.info(order.getOrderRows());
            for (OrderRow orderRow : order.getOrderRows()) {
                logger.info(orderRow);
                logger.info(orderRow.getProduct());
            }
        }


        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
