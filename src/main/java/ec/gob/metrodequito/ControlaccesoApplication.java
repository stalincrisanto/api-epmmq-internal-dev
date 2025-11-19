package ec.gob.metrodequito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ec.gob.metrodequito")
@EnableJpaRepositories(basePackages = "ec.gob.metrodequito")
@EnableJpaAuditing
public class ControlaccesoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlaccesoApplication.class, args);
	}
}
