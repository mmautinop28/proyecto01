package pe.com.avicola.java.ms.avi.gestion.empresa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.avicola.java.ms.avi.gestion.empresa.dto.EmpresaDTO;
import pe.com.avicola.java.ms.avi.gestion.empresa.entity.EmpresaEntity;
import pe.com.avicola.java.ms.avi.gestion.empresa.repository.EmpresaRepository;
import pe.com.avicola.java.ms.avi.gestion.empresa.service.exception.ServiceException;

@Service
public class EmpresaServiceImpl implements EmpresaService{
 
	private EmpresaRepository proveedorRepository;
	private JsonMapper jsonMapper;
	
	public EmpresaServiceImpl(	EmpresaRepository proveedorRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.proveedorRepository = proveedorRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<EmpresaDTO> findByLike(EmpresaDTO t) throws ServiceException {
		try {
			List<EmpresaEntity> lstProveedorEntity= proveedorRepository.findAll();
			return lstProveedorEntity.stream().map(e -> this.getProveedorDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<EmpresaDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// Mappers
	private EmpresaDTO getProveedorDTO(EmpresaEntity e) {
		return jsonMapper.convertValue(e, EmpresaDTO.class);
	}
	
	private EmpresaEntity getProveedorEntity(EmpresaDTO d) {
		return jsonMapper.convertValue(d, EmpresaEntity.class);
	}
	
}
