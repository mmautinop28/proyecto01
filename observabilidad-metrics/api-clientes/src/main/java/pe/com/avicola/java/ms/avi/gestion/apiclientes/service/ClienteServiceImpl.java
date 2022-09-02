package pe.com.avicola.java.ms.avi.gestion.apiclientes.service;

import java.util.List;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.avi.gestion.apiclientes.entity.Cliente;
import pe.com.avicola.java.ms.avi.gestion.apiclientes.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository=clienteRepository;
	}

	@Override
	public List<Cliente> findAll() {

		return clienteRepository.findAllCustom();
	}

	@Override
	public Cliente insert(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}
