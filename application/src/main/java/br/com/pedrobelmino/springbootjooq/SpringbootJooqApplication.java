package br.com.pedrobelmino.springbootjooq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootJooqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJooqApplication.class, args);
	}

}
