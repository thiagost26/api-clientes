package com.home.clientes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.home.clientes.entity.Cliente;
import com.home.clientes.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
	
	@Autowired
	private ClienteService service;
	
	
	@GetMapping
	public List<Cliente> mostrarTodos() {
		return service.listarClientes();
	}
	
	
	@GetMapping("/{id}")
	public Cliente getOne(@PathVariable Long id) {
		return service.listarUmCliente(id);
	}
	

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		service.excluirCliente(id);
	}
	
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		service.atualizarCliente(id, clienteAtualizado);
	}
}
