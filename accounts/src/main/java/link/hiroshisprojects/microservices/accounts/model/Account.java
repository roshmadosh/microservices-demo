package link.hiroshisprojects.microservices.accounts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long accountId;
   private long customerId;
   private AccountType accountType;
   private String branchAddress;
   private LocalDate createDate;
}
