package pl.bogus.hibernate.modul7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Customer;
import pl.bogus.hibernate.entity.Order;
import pl.bogus.hibernate.entity.OrderRow;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class App33CriteriaJoin {


    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> customerRoot = criteriaQuery.from(Customer.class);
        Join<Object, Object> orders = (Join) customerRoot.fetch("orders", JoinType.INNER);
        orders.fetch("orderRows").fetch("product");
        ParameterExpression<Long> id = criteriaBuilder.parameter(Long.class);
        ParameterExpression<Long> id2 = criteriaBuilder.parameter(Long.class);
        ParameterExpression<BigDecimal> total = criteriaBuilder.parameter(BigDecimal.class);
        criteriaQuery.select(customerRoot)
                .distinct(true)
                .where(
                        criteriaBuilder.and(
                                criteriaBuilder.or(
                                criteriaBuilder.equal(customerRoot.get("id"), id),
                                criteriaBuilder.equal(customerRoot.get("id"), id2)),
                                criteriaBuilder.greaterThan(orders.get("total"), total)
                        ));


        TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);
        query.setParameter(id, 1L);
        query.setParameter(id2, 2L);
        query.setParameter(total, new BigDecimal("20.00"));


        List<Customer> resultList = query.getResultList();
        for (
                Customer customer : resultList) {
            logger.info(customer);
            logger.info(customer.getOrders());
            for (Order order : customer.getOrders()) {
                logger.info(order);
                for (OrderRow orderRow : order.getOrderRows()) {
                    logger.info(orderRow);
                    logger.info(orderRow.getProduct());
                }
            }
        }


        entityManager.getTransaction().

                commit();
        entityManager.close();
    }

}
