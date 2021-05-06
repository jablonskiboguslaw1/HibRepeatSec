package pl.bogus.hibernate.modul5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.ProductInCategoryCounterDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class App17JPQLAutomaticResponseMapping {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "select new pl.bogus.hibernate.entity.ProductInCategoryCounterDto(p.category.id, Count(p)) from Product p " +
                        "group by p.category" );


        List<ProductInCategoryCounterDto> resultList = query.getResultList();



        for (ProductInCategoryCounterDto dto : resultList) {
            logger.info(dto.getCategoryId()+ " "+ dto.getProductInCategoryCounter());
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
