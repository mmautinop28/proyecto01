package pe.com.avicola.java.ms.avi.gestion.producto.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import pe.com.avicola.java.ms.avi.gestion.producto.dto.ProductoDTO;
import pe.com.avicola.java.ms.avi.gestion.producto.entity.ProductoEntity;
import pe.com.avicola.java.ms.avi.gestion.producto.repository.ProductoRepository;
import pe.com.avicola.java.ms.avi.gestion.producto.service.exception.ServiceException;

@Service
public class ProductoServiceImpl implements ProductoService{
 
	private ProductoRepository proveedorRepository;
	private JsonMapper jsonMapper;
	
	public ProductoServiceImpl(	ProductoRepository proveedorRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.proveedorRepository = proveedorRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ProductoDTO> findByLike(ProductoDTO t) throws ServiceException {
		try {
			List<ProductoEntity> lstProveedorEntity= proveedorRepository.findAll();
			return lstProveedorEntity.stream().map(e -> this.getProveedorDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ProductoDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// Mappers
	private ProductoDTO getProveedorDTO(ProductoEntity e) {
		return jsonMapper.convertValue(e, ProductoDTO.class);
	}
	
	private ProductoEntity getProveedorEntity(ProductoDTO d) {
		return jsonMapper.convertValue(d, ProductoEntity.class);
	}
	
}
