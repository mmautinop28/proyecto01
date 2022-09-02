package pe.com.avicola.java.ms.avi.gestion.vehiculo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.avicola.java.ms.avi.gestion.vehiculo.dto.VehiculoDTO;
import pe.com.avicola.java.ms.avi.gestion.vehiculo.entity.VehiculoEntity;
import pe.com.avicola.java.ms.avi.gestion.vehiculo.repository.VehiculoRepository;
import pe.com.avicola.java.ms.avi.gestion.vehiculo.service.exception.ServiceException;

@Service
public class VehiculoServiceImpl implements VehiculoService{
 
	private VehiculoRepository proveedorRepository;
	private JsonMapper jsonMapper;
	
	public VehiculoServiceImpl(	VehiculoRepository proveedorRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.proveedorRepository = proveedorRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<VehiculoDTO> findByLike(VehiculoDTO t) throws ServiceException {
		try {
			List<VehiculoEntity> lstProveedorEntity= proveedorRepository.findAll();
			return lstProveedorEntity.stream().map(e -> this.getProveedorDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<VehiculoDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// Mappers
	private VehiculoDTO getProveedorDTO(VehiculoEntity e) {
		return jsonMapper.convertValue(e, VehiculoDTO.class);
	}
	
	private VehiculoEntity getProveedorEntity(VehiculoDTO d) {
		return jsonMapper.convertValue(d, VehiculoEntity.class);
	}
	
}
