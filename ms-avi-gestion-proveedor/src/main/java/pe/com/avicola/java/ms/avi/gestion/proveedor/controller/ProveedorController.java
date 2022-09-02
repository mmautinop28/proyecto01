package pe.com.avicola.java.ms.avi.gestion.proveedor.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.proveedor.dto.ProveedorDTO;
import pe.com.avicola.java.ms.avi.gestion.proveedor.service.ProveedorService;

import static pe.com.avicola.java.ms.avi.gestion.proveedor.commons.GlobalConstants.API_PROVEEDOR;
import static pe.com.avicola.java.ms.avi.gestion.proveedor.commons.GlobalConstants.COD_CONSULTA_EXITO;
import static pe.com.avicola.java.ms.avi.gestion.proveedor.commons.GlobalConstants.MSG_CONSULTA_EXITO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_PROVEEDOR)
public class ProveedorController {

	private ProveedorService proveedorService;

	public ProveedorController(ProveedorService proveedorService) {
		super();
		this.proveedorService = proveedorService;
	}

	
	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<ProveedorDTO> lstProveedorDTO= this.proveedorService.findByLike(null);
			if (lstProveedorDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_CONSULTA_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstProveedorDTO)
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
