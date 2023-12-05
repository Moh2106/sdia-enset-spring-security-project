package ma.enset.customerfrontthymleafapp;

import ma.enset.customerfrontthymleafapp.entities.Customer;
import ma.enset.customerfrontthymleafapp.repositories.CustomerRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerFrontThymleafAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerFrontThymleafAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepositories customerRepositories){
        return args -> {
            customerRepositories.save(Customer.builder().name("Mohamed").email("med@gmail.com").build());
            customerRepositories.save(Customer.builder().name("Imane").email("imane@gmail.com").build());
            customerRepositories.save(Customer.builder().name("Adissa").email("adi@gmail.com").build());
        };
    }
}
