package link.hiroshisprojects.microservices.accounts.repository;

import link.hiroshisprojects.microservices.accounts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
