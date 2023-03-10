package link.hiroshisprojects.microservices.accounts.repository;

import link.hiroshisprojects.microservices.accounts.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByCustomerId(long customerId);

}
