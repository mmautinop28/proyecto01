package pe.com.avicola.java.ms.avi.gestion.clientes.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.avicola.java.ms.avi.gestion.clientes.dto.ClienteDTO;
import pe.com.avicola.java.ms.avi.gestion.clientes.entity.ClienteEntity;
import pe.com.avicola.java.ms.avi.gestion.clientes.repository.ClienteRepository;
import pe.com.avicola.java.ms.avi.gestion.clientes.service.exception.ServiceException;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	private JsonMapper jsonMapper;
	
	public ClienteServiceImpl(	ClienteRepository clienteRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.clienteRepository = clienteRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ClienteDTO> findByLike(ClienteDTO t) throws ServiceException {
		try {
			List<ClienteEntity> lstClienteEntity= clienteRepository.findAll();
			return lstClienteEntity.stream().map(e -> this.getClienteDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ClienteDTO> findById(Long id) throws ServiceException {
		Optional<ClienteEntity> optClienteEntity=  clienteRepository.findById(id);
		if(optClienteEntity.isPresent()) {
			return Optional.of(this.getClienteDTO(optClienteEntity.get()));
		}
		return null;
	}

	// Mappers
	private ClienteDTO getClienteDTO(ClienteEntity e) {
		return jsonMapper.convertValue(e, ClienteDTO.class);
	}
	
	private ClienteEntity getClienteEntity(ClienteDTO d) {
		return jsonMapper.convertValue(d, ClienteEntity.class);
	}

	@Override
	public ClienteDTO save(ClienteDTO t) throws ServiceException {
		return this.getClienteDTO(this.clienteRepository.save(this.getClienteEntity(t)));
	}
	
}
