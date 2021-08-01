package com.home.clientes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ClienteNotFound(Long id) {
		super(String.format("Cliente não encontrado!", id));
	}

}
