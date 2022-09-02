package pe.com.avicola.java.ms.gestion.pedidos;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test1")
public class TracerGestionPedidos {

	@GetMapping
	public String GestionPedidos() {
		String message = "Avicola El Chino: " + LocalDate.now();
		log.info(message);
		return message;
	}
	
}
