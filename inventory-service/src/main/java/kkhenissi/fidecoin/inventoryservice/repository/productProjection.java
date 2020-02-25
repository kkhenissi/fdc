package kkhenissi.fidecoin.inventoryservice.repository;

import kkhenissi.fidecoin.inventoryservice.entities.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p2", types = Product.class)
public interface productProjection {
    public Long getProductId();
    public String getCurrentPrice();
}
