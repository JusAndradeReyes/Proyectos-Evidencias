package com.producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootFormatApiRestProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFormatApiRestProductoApplication.class, args);
	}

}
