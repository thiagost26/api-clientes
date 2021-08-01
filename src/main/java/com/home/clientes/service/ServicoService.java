package com.home.clientes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.clientes.entity.Servico;
import com.home.clientes.repository.ServicosRepository;

@Service
public class ServicoService {
	
	@Autowired
	private ServicosRepository servicosRepository;
	
	
	public List<Servico> listarServicos() {
		return servicosRepository.findAll(); 
	}


	public Optional<Servico> listarUmServico(Long id) {		
		Optional<Servico> servicoOptional = servicosRepository.findById(id);
		
		return servicoOptional;
	}

}
