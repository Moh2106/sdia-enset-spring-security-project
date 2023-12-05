package ma.enset.customerfrontthymleafapp.repositories;

import ma.enset.customerfrontthymleafapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositories extends JpaRepository<Customer, Long> {
}
