package pe.com.avicola.java.ms.avi.gestion.pedidos.rest;

import static pe.com.avicola.java.ms.avi.gestion.rest.commons.Constants.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.pedidos.document.Orden;
import pe.com.avicola.java.ms.avi.gestion.pedidos.producer.OrdenProducer;

@Slf4j
@RestController
@RequestMapping(API_PEDIDOS_PRODUCER)
public class PedidoRest {

	private OrdenProducer ordenProducer;

	public PedidoRest(OrdenProducer ordenProducer) {

		this.ordenProducer = ordenProducer;
	}

	@PostMapping
	public ResponseEntity<?> send(@RequestBody Orden orden) {

		try {
			ordenProducer.sendMessage(orden);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
		
	};

}
