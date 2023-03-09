package link.hiroshisprojects.microservices.accounts.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    @NotNull(message = "'email' is required.")
    private String email;
    private LocalDateTime createDate;

    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            mappedBy = "customer", orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        account.setCustomer(this)
                .setCreateDate(LocalDateTime.now());
        if (accounts.contains(account)) {
            throw new RuntimeException("Account of type " + account.getAccountType() + " already exists for this customer.");
        }

        accounts.add(account);
    }

}
