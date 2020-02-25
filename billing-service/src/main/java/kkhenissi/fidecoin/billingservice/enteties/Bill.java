package kkhenissi.fidecoin.billingservice.enteties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private Date billingDate;
    private Long customerId;
    @Transient private  Customer customer;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;
}
