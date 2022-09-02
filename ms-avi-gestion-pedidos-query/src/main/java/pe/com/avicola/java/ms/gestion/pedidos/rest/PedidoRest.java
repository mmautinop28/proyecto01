package pe.com.avicola.java.ms.gestion.pedidos.rest;

import static pe.com.avicola.java.ms.gestion.pedidos.rest.commons.Constants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;
import pe.com.avicola.java.ms.gestion.pedidos.service.PedidoService;
import pe.com.avicola.java.ms.gestion.pedidos.service.exception.ServiceException;

@Slf4j
@RestController
@RequestMapping(API_PEDIDOS_QUERY)
public class PedidoRest {
	
	private PedidoService	pedidoService;
	
	public PedidoRest(PedidoService	pedidoService) {
		
		this.pedidoService=pedidoService;
	}

	
	@GetMapping
	public ResponseEntity<?> findLike(/*@RequestParam(name = "glosa", defaultValue = "") String glosa*/){
		try {
			return ResponseEntity.ok(pedidoService.findLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		
		try {
			return ResponseEntity.ok(pedidoService.findById(Orden.builder().id(id).build()));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
}
