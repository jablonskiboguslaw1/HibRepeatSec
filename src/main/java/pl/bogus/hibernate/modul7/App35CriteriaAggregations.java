package pl.bogus.hibernate.modul7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App35CriteriaAggregations {


    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");


    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = criteriaBuilder.createQuery(Object[].class);
        Root<Customer> customer = query.from(Customer.class);
        Join<Object, Object> orders = customer.join("orders", JoinType.INNER);
        Join<Object, Object> orderRows = orders.join("orderRows");
        Join<Object, Object> product = orderRows.join("product");
        Join<Object, Object> category = product.join("category");


   /*     query.select(
                criteriaBuilder.array(
                        customer.get("id"),
                        customer.get("lastname"),
                        category.get("name")
                )
        );*/

             query.multiselect(
                        customer.get("id"),
                        customer.get("lastname"),
                        category.get("name"),
                     criteriaBuilder.sum(orderRows.get("price"))
        ).groupBy(category.get("id"),customer.get("id"))
             .orderBy(criteriaBuilder.desc(criteriaBuilder.sum(orderRows.get("price"))))
             .having(criteriaBuilder.greaterThan(criteriaBuilder.sum(orderRows.get("price")),50));
        TypedQuery<Object[]> query1 = entityManager.createQuery(query);
        List<Object[]> resultList = query1.getResultList();
        for (Object[] row : resultList) {
            logger.info(row[0]+" "+row[1]+" "+row[2]+ ", "+ row[3]);

        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
