package link.hiroshisprojects.microservices.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("link.hiroshisprojects.microservices.accounts.controller")
@EnableJpaRepositories("link.hiroshisprojects.microservices.accounts.repository")
@EntityScan("link.hiroshisprojects.microservices.accounts.model")
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
