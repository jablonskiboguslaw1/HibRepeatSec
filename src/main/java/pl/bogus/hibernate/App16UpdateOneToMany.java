package pl.bogus.hibernate;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bogus.hibernate.entity.Attribute;
import pl.bogus.hibernate.entity.Product;
import pl.bogus.hibernate.entity.Review;
import pl.bogus.hibernate.entity.ReviewDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App16UpdateOneToMany {
    private static Logger logger = LogManager.getLogger();
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<ReviewDto> updatedReviews = getUpdatedReviews();

        Product product = entityManager.find(Product.class, 3L);

        for (Review review : product.getReviews()) {
            for (ReviewDto updatedReview : updatedReviews) {
             if (review.getId().equals(updatedReview.getId())){
                 review.setContent(updatedReview.getContent());
                 review.setRating(updatedReview.getRating());
                }
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }


    private static List<ReviewDto> getUpdatedReviews(){
        List<ReviewDto> rewievs = new ArrayList<>();

        rewievs.add(new ReviewDto(13L,"Modified content 13" , 10));
        rewievs.add(new ReviewDto(14L,"Modified content 14" , 10));
        rewievs.add(new ReviewDto(15L,"Modified content 15" , 10));
return rewievs;

    }
}
