package kkhenissi.fidecoin.billingservice.enteties;

import lombok.Data;

@Data
public class Customer {
    private Long customerId;
    private String customerName;
    private String customerEmail;

}
