package link.hiroshisprojects.microservices.accounts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Entity
@Accessors(chain = true)
@Getter @Setter @ToString
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long accountId;

   @ManyToOne
   @JsonBackReference
   private Customer customer;

   @NotNull(message = "Account type is required.")
   private AccountType accountType;

   private String branchAddress;

   @Column(name="create_date", nullable = false)
   private LocalDateTime createDate;


}
