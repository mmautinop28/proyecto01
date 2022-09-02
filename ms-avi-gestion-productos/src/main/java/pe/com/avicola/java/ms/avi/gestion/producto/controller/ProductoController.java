package pe.com.avicola.java.ms.avi.gestion.producto.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.producto.dto.ProductoDTO;
import pe.com.avicola.java.ms.avi.gestion.producto.service.ProductoService;

import static pe.com.avicola.java.ms.avi.gestion.producto.commons.GlobalConstants.API_PRODUCTO;
import static pe.com.avicola.java.ms.avi.gestion.producto.commons.GlobalConstants.COD_CONSULTA_EXITO;
import static pe.com.avicola.java.ms.avi.gestion.producto.commons.GlobalConstants.MSG_CONSULTA_EXITO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_PRODUCTO)
public class ProductoController {

	private ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}

	
	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<ProductoDTO> lstProductoDTO= this.productoService.findByLike(null);
			if (lstProductoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_CONSULTA_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstProductoDTO)
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
