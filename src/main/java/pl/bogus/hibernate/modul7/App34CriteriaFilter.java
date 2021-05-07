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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App34CriteriaFilter {


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
        ParameterExpression<Collection> ids = criteriaBuilder.parameter(Collection.class);
        ParameterExpression<BigDecimal> total = criteriaBuilder.parameter(BigDecimal.class);
        criteriaQuery.select(customerRoot)
                .distinct(true)
                .where(
                        criteriaBuilder.and(
                                customerRoot.get("id").in(ids),
                                criteriaBuilder.between(orders.get("total"), total, criteriaBuilder.literal(new BigDecimal("70.00"))),
                                criteriaBuilder.isNotNull(customerRoot.get("firstname"))
                        ));


        TypedQuery<Customer> query = entityManager.createQuery(criteriaQuery);

query.setParameter(ids,Arrays.asList(2L,3L,4L));
        query.setParameter(total, new BigDecimal("20.00"));


        List<Customer> resultList = query.getResultList();
        for (
                Customer customer : resultList) {
            logger.info(customer);
            logger.info(customer.getOrders());
             /*  for (Order order : customer.getOrders()) {
                logger.info(order);
             for (OrderRow orderRow : order.getOrderRows()) {
                    logger.info(orderRow);
                    logger.info(orderRow.getProduct());
                }
            }*/
        }


        entityManager.getTransaction().

                commit();
        entityManager.close();
    }

}
