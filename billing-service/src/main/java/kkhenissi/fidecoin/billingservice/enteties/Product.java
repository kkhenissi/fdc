package kkhenissi.fidecoin.billingservice.enteties;

import lombok.Data;

@Data
public class Product {
    public Long productId;
    public String productDesignation;
    public Double initialPrice;
    public Double actualPrice;
}
