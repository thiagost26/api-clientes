package com.home.clientes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.clientes.entity.Cliente;
import com.home.clientes.entity.Servico;
import com.home.clientes.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicosController {
	
	@Autowired
	private ServicoService servicoService;
	
	
	
	@GetMapping
	public List<Servico> mostrarTodos() {
		return servicoService.listarServicos();
	}
	
	
	@GetMapping("/{id}")
	public Optional<Servico> getOne(@PathVariable Long id) {
		return servicoService.listarUmServico(id);
	}

}
