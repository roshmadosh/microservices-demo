package link.hiroshisprojects.microservices.accounts.controller;

import link.hiroshisprojects.microservices.accounts.model.Account;
import link.hiroshisprojects.microservices.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity<Iterable<Account>> getAllAccounts(@RequestParam long customerId) {
        System.out.println("CUSTOMER ID: " + customerId);
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return ResponseEntity.ok().body(accounts);
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account saved;
        try {
            saved = accountRepository.save(account);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return ResponseEntity.badRequest().build();
    }

}
