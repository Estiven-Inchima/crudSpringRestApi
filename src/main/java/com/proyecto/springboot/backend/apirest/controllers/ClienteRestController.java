package com.proyecto.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.springboot.backend.apirest.models.entity.Cliente;
import com.proyecto.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api") 
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	//metodo para listar/buscar todo
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	//metodo para buscar por id
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	//metodo para crear/guardar
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)//con esto decimos que si se crear correctamente se retorne un ok o codigo 201(201 indica que se creo contenido)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	//metodo para actualizar
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id); 
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	//metodo para eliminar
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
	
}
