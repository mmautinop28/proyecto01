package pe.com.avicola.java.ms.avi.gestion.detallepedidos.controller;

import static pe.com.avicola.java.ms.avi.gestion.detallepedidos.controller.commons.Constants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.dto.DetallePedidoDTO;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.DetallePedidoService;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.exception.ServiceException;

@Slf4j
@RestController
@RequestMapping(API_DETALLE_PEDIDOS)
public class DetallePedidoRest {

	@Autowired
	private DetallePedidoService detallePedidoService;
	
	
	@GetMapping
	public ResponseEntity<?> findLike(@RequestParam(name = "nombre", defaultValue = "") String nombre){
		try {
			return ResponseEntity.ok(detallePedidoService.findLike(null));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		
		try {
			System.out.println("DetallePedidoDTO.builder --> " + DetallePedidoDTO.builder());
			System.out.println("DetallePedidoDTO.builder().id(id) --> " + DetallePedidoDTO.builder().id(id));
			System.out.println("DetallePedidoDTO.builder().id(id).build() --> " + DetallePedidoDTO.builder().id(id).build());
			return ResponseEntity.ok(detallePedidoService.findById(DetallePedidoDTO.builder().id(id).build()).get());
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody @Validated DetallePedidoDTO detallePedidoDTO){
		// Lectura de BD
		// Cosumo del MS cliente
		return null;
	};
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Validated DetallePedidoDTO detallePedidoDTO){
		
		return null;
	};
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		
		return null;
	};
	
}
