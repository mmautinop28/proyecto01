package pe.com.avicola.java.ms.avi.gestion.detallepedidos.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.dto.DetallePedidoDTO;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.entity.DetallePedidoEntity;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.repository.DetallePedidoRepository;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client.PedidoService;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.exception.ServiceException;

@Slf4j
@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

	@Autowired
	private JsonMapper 			jsonMapper;

	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Autowired
	private PedidoService	 	pedidoService;

	@Override
	public List<DetallePedidoDTO> findLike(DetallePedidoDTO detallePedidoDTO) throws ServiceException {
		try {
			return this.detallePedidoRepository.getAllActivos().stream().map(e -> this.getDetallePedidoDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	// API Composite
	
	@Override
	public Optional<DetallePedidoDTO> findById(DetallePedidoDTO detallePedidoDTO) throws ServiceException {
		try {
			//log.info("id "+detallePedidoDTO.getId());
			System.out.println("detallePedidoDTO.getId() ---> " + detallePedidoDTO.getId());
			Optional<DetallePedidoEntity> detallePedidoEntity= this.detallePedidoRepository.findById(detallePedidoDTO.getId());
			if (detallePedidoEntity.isPresent()) {
				//log.info("isPresent... "+pedidoEntity.get());
				
				DetallePedidoDTO oDetallePedidoDTO=this.getDetallePedidoDTO(detallePedidoEntity.get());
				if (!Objects.isNull(oDetallePedidoDTO)) {
					System.out.println("oDetallePedidoDTO.getIdPedido() ---> " + oDetallePedidoDTO.getIdPedido());
					oDetallePedidoDTO.setPedido(pedidoService.findById(oDetallePedidoDTO.getIdPedido()));
				}

				 return Optional.of(oDetallePedidoDTO);
			}
			//log.info("empty... ");
			return Optional.empty();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public DetallePedidoDTO save(DetallePedidoDTO pedidoDTO) throws ServiceException {
		return null;
	}

	// Mappers

	private DetallePedidoDTO getDetallePedidoDTO(DetallePedidoEntity detallePedidoEntity) {
		return jsonMapper.convertValue(detallePedidoEntity, DetallePedidoDTO.class);
	}

}
