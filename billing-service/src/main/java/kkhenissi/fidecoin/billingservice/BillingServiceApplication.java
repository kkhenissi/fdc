package kkhenissi.fidecoin.billingservice;

import kkhenissi.fidecoin.billingservice.enteties.Bill;
import kkhenissi.fidecoin.billingservice.enteties.Customer;
import kkhenissi.fidecoin.billingservice.enteties.Product;
import kkhenissi.fidecoin.billingservice.enteties.ProductItem;
import kkhenissi.fidecoin.billingservice.repository.BillRepository;
import kkhenissi.fidecoin.billingservice.repository.ProductItemRepository;
import kkhenissi.fidecoin.billingservice.service.CustomerService;
import kkhenissi.fidecoin.billingservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerService customerService, InventoryService inventoryService) {

		return args -> {

			Customer c1=customerService.findCustomerById(1L);

			System.out.println("**************************************************");
			System.out.println("ID = "+c1.getCustomerId());
			System.out.println("Email ="+c1.getCustomerEmail());
			System.out.println("Name = "+c1.getCustomerName());

			System.out.println("*****************************************************");



           Product p1 =inventoryService.findProductById(1L);
			System.out.println("**************************************************");
			System.out.println(" ProductID = "+p1.getProductId());
			System.out.println("Designation ="+p1.getProductDesignation());
			System.out.println("price = "+p1.getActualPrice());

			System.out.println("*****************************************************");

			Bill b1 = billRepository.save(new Bill(null, new Date(),c1.getCustomerId(),null,null));

			PagedModel<Product> products = inventoryService.findAllProducts();
			products.getContent().forEach(p-> {
				productItemRepository.save(new ProductItem(null,p.getProductId(),null,p.getInitialPrice(),p.getActualPrice(),b1));
			});

//
//			productItemRepository.save(new ProductItem(null,p1.getProductId(),p1.getInitialPrice(),p1.getActualPrice(),b1));
//			Product p2 =inventoryService.findProductById(2L);
//			productItemRepository.save(new ProductItem(null,p2.getProductId(),p2.getInitialPrice(),p2.getActualPrice(),b1));
//			Product p3 =inventoryService.findProductById(3L);
//			productItemRepository.save(new ProductItem(null,p3.getProductId(),p3.getInitialPrice(),p3.getActualPrice(),b1));
//			Product p4 =inventoryService.findProductById(4L);
//			productItemRepository.save(new ProductItem(null,p4.getProductId(),p4.getInitialPrice(),p4.getActualPrice(),b1));

		};

	}

}
