package pe.com.avicola.java.ms.avi.gestion.proveedor.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.avicola.java.ms.avi.gestion.proveedor.dto.ProveedorDTO;
import pe.com.avicola.java.ms.avi.gestion.proveedor.entity.ProveedorEntity;
import pe.com.avicola.java.ms.avi.gestion.proveedor.repository.ProveedorRepository;
import pe.com.avicola.java.ms.avi.gestion.proveedor.service.exception.ServiceException;

@Service
public class ProveedorServiceImpl implements ProveedorService{
 
	private ProveedorRepository proveedorRepository;
	private JsonMapper jsonMapper;
	
	public ProveedorServiceImpl(	ProveedorRepository proveedorRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.proveedorRepository = proveedorRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ProveedorDTO> findByLike(ProveedorDTO t) throws ServiceException {
		try {
			List<ProveedorEntity> lstProveedorEntity= proveedorRepository.findAll();
			return lstProveedorEntity.stream().map(e -> this.getProveedorDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ProveedorDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// Mappers
	private ProveedorDTO getProveedorDTO(ProveedorEntity e) {
		return jsonMapper.convertValue(e, ProveedorDTO.class);
	}
	
	private ProveedorEntity getProveedorEntity(ProveedorDTO d) {
		return jsonMapper.convertValue(d, ProveedorEntity.class);
	}
	
}
