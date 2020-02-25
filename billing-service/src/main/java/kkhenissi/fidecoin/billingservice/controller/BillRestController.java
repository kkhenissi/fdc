package kkhenissi.fidecoin.billingservice.controller;

import kkhenissi.fidecoin.billingservice.enteties.Bill;
import kkhenissi.fidecoin.billingservice.repository.BillRepository;
import kkhenissi.fidecoin.billingservice.repository.ProductItemRepository;
import kkhenissi.fidecoin.billingservice.service.CustomerService;
import kkhenissi.fidecoin.billingservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    CustomerService  customerService;
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/fullBill/{id}")
    public  Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi-> {
            pi.setProduct(inventoryService.findProductById(pi.getProductId()));
        });
        return bill;
    }
}
