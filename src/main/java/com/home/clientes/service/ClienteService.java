package com.home.clientes.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.home.clientes.entity.Cliente;
import com.home.clientes.exception.ClienteNotFound;
import com.home.clientes.repository.ClientesRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	
	public List<Cliente> listarClientes() {
		return clientesRepository.findAll(); 
	}


	public Cliente listarUmCliente(Long id) throws ClienteNotFound {		
		Cliente clienteOptional = clientesRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		return clienteOptional;
	}


	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clientesRepository.save(cliente);
	}


	@Transactional
	public void excluirCliente(Long id) {
		clientesRepository.findById(id)
				.map(cliente -> {
					clientesRepository.delete(cliente);
					return Void.TYPE;
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
	
	
	
	public void atualizarCliente(Long id, Cliente clienteAtualizado) {
		clientesRepository.findById(id)
				.map(cliente -> {
					clienteAtualizado.setId(cliente.getId());
					clienteAtualizado.setDataCadastro(LocalDate.now());
					return clientesRepository.save(clienteAtualizado);
				})
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
