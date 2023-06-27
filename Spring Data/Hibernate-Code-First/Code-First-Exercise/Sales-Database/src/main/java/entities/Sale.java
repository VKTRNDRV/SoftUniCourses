package entities;

import javax.crypto.CipherSpi;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id"
            , referencedColumnName = "id")
    private Product product;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id"
            , referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(targetEntity = StoreLocation.class)
    @JoinColumn(name = "store_location_id"
            , referencedColumnName = "id")
    private StoreLocation storeLocation;

    @Column(name = "date")
    private Date date;
}
