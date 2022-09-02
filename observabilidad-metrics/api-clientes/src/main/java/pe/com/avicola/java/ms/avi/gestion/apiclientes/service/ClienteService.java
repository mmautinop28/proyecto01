package pe.com.avicola.java.ms.avi.gestion.apiclientes.service;

import java.util.List;

import pe.com.avicola.java.ms.avi.gestion.apiclientes.entity.Cliente;

public interface ClienteService {

	List<Cliente> findAll();
	
	Cliente insert(Cliente cliente);
	
}
