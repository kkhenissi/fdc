package kkhenissi.fidecoin.customerservice.repository;

import kkhenissi.fidecoin.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
}
