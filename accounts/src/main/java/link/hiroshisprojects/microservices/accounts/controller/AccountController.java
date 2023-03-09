package link.hiroshisprojects.microservices.accounts.controller;

import link.hiroshisprojects.microservices.accounts.model.Account;
import link.hiroshisprojects.microservices.accounts.model.Customer;
import link.hiroshisprojects.microservices.accounts.repository.AccountRepository;
import link.hiroshisprojects.microservices.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<Iterable<Account>> getAllAccounts(@RequestParam long customerId) {
        System.out.println("CUSTOMER ID: " + customerId);
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return ResponseEntity.ok().body(accounts);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam long customerId, @RequestBody Account account) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException("Customer ID not found."));
        try {
            customer.addAccount(account);
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok().body(savedCustomer.getAccounts().get(customer.getAccounts().size() - 1));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
       return ResponseEntity.badRequest().build();
    }

}
