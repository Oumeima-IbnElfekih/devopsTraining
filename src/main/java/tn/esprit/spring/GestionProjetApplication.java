package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class GestionProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionProjetApplication.class, args);
	}

}
