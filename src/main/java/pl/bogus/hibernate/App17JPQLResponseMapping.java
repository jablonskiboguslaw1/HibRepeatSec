package pl.bogus.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.ProductInCategoryCounterDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class App17JPQLResponseMapping {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "select p.category.id, Count(p) from Product p " +
                        "group by p.category" );


        List<ProductInCategoryCounterDto> result = ((List<Object[]>) query.getResultList()).stream()
                .map(objects -> new ProductInCategoryCounterDto((Long) objects[0], (Long) objects[1]))
                .collect(Collectors.toList());

        for (ProductInCategoryCounterDto dto : result) {
            logger.info(dto.getCategoryId()+ " "+ dto.getProductInCategoryCounter());
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
