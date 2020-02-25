package kkhenissi.fidecoin.inventoryservice;

import kkhenissi.fidecoin.inventoryservice.entities.Product;
import kkhenissi.fidecoin.inventoryservice.repository.ProductRepository;
import net.minidev.json.JSONUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		return  args -> {
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "computer Dell ",1200.00,600.00));
			productRepository.save(new Product(null, "APN Sony ",1500.00,300.00));
			productRepository.save(new Product(null, "Printer XROX ",2200.00,1600.80));
			productRepository.save(new Product(null, "Television Philips 52 p ",1400.00,720.50));
			productRepository.save(new Product(null, "Drone XERGD Dell ",1100.00,330.50));
			productRepository.findAll().forEach(System.out::println);
		};
	};

}
