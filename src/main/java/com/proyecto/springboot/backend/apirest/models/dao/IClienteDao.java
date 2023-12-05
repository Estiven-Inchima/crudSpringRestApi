package com.proyecto.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.springboot.backend.apirest.models.entity.Cliente;

//en este dao usamos DATA-JPA

public interface IClienteDao extends CrudRepository<Cliente, Long>{

	
}
