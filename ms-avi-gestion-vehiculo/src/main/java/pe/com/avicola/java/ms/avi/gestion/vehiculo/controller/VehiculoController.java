package pe.com.avicola.java.ms.avi.gestion.vehiculo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.vehiculo.dto.VehiculoDTO;
import pe.com.avicola.java.ms.avi.gestion.vehiculo.service.VehiculoService;

import static pe.com.avicola.java.ms.avi.gestion.vehiculo.commons.GlobalConstants.API_VEHICULO;
import static pe.com.avicola.java.ms.avi.gestion.vehiculo.commons.GlobalConstants.COD_CONSULTA_EXITO;
import static pe.com.avicola.java.ms.avi.gestion.vehiculo.commons.GlobalConstants.MSG_CONSULTA_EXITO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_VEHICULO)
public class VehiculoController {

	private VehiculoService vehiculoService;

	public VehiculoController(VehiculoService vehiculoService) {
		super();
		this.vehiculoService = vehiculoService;
	}

	
	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<VehiculoDTO> lstVehiculoDTO= this.vehiculoService.findByLike(null);
			if (lstVehiculoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_CONSULTA_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstVehiculoDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/*
	@GetMapping
	public List<ProductoDTO>  findByLike() throws ServiceException{
		return this.productoService.findByLike(null);
	}*/
}
