package com.api_ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api_ventas")
public class VentasAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasAppApplication.class, args);
	}

}
