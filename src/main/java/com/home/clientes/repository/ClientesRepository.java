package com.home.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.clientes.entity.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Long> {
	
	
}
