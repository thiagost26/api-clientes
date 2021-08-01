package com.home.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.clientes.entity.Servico;

@Repository
public interface ServicosRepository extends JpaRepository<Servico, Long> {
	
}
