package link.hiroshisprojects.microservices.accounts.repository;

import link.hiroshisprojects.microservices.accounts.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
