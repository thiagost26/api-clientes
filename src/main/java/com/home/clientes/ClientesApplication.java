package com.home.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientesApplication {
	
//	@Bean
//	public CommandLineRunner run(@Autowired ClientesRepository clientesRepository) {
//		return args -> {
//			Cliente cliente = Cliente.builder()
//					.nome("John")
//					.cpf("44400088822")
//					.build();
//			clientesRepository.save(cliente);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
