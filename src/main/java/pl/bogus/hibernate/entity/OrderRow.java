package pl.bogus.hibernate.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_row")
public class OrderRow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
@OneToOne(fetch = FetchType.LAZY)
private Product product;

    public BigDecimal getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderRow{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
