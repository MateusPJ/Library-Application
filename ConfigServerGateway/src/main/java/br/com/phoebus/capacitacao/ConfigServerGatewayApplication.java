package br.com.phoebus.capacitacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigServerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGatewayApplication.class, args);
	}

}
