package com.proyecto.springboot.backend.apirest.models.services;

import java.util.List;

import com.proyecto.springboot.backend.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();//contrato de buscar todos
	
	//implementamos el crud
	public Cliente findById(Long id);
	public Cliente save(Cliente cliente);
	public void delete(Long id);
	
}
