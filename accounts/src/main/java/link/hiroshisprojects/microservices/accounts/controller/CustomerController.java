package link.hiroshisprojects.microservices.accounts.controller;

import jakarta.validation.Valid;
import link.hiroshisprojects.microservices.accounts.model.Account;
import link.hiroshisprojects.microservices.accounts.model.Customer;
import link.hiroshisprojects.microservices.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        customer.setCreateDate(LocalDateTime.now());
        try {
            customer = customerRepository.save(customer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(customer);
    }

}
