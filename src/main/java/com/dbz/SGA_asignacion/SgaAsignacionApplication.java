package com.dbz.SGA_asignacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SgaAsignacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgaAsignacionApplication.class, args);
	}

}
