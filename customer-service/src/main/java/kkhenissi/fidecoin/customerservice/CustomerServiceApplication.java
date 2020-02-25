package kkhenissi.fidecoin.customerservice;

import kkhenissi.fidecoin.customerservice.entities.Customer;
import kkhenissi.fidecoin.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
      return  args -> {
      	repositoryRestConfiguration.exposeIdsFor(Customer.class);
		  customerRepository.save(new Customer(null, "azerty", "azerty@gmail.com"));
		  customerRepository.save(new Customer(null, "qwerty", "qwerty@gmail.com"));
		  customerRepository.save(new Customer(null, "abcdef", "abcdef@gmail.com"));

		  customerRepository.findAll().forEach(System.out::println);
	  };
	}

}
