package pe.com.avicola.java.ms.gestion.pedidos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import lombok.Data;
import pe.com.avicola.java.ms.gestion.pedidos.model.Pedido;
import pe.com.avicola.java.ms.gestion.pedidos.repository.PedidoRepository;
import static pe.com.avicola.java.ms.gestion.pedidos.controller.commons.Constants.*;

@Data
@RestController
@RequestMapping(API_PEDIDOS)
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@PostMapping
	public Pedido save(@RequestBody Pedido Pedido) {
		pedidoRepository.save(Pedido);
		return Pedido;
	}

	@GetMapping
	public List<?> list() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	public Pedido getPedido(@PathVariable Long id) {
		return pedidoRepository.findById(id);
	}

	@PutMapping
	public Pedido update(@RequestBody Pedido Pedido) {
		pedidoRepository.update(Pedido);
		return Pedido;
	}

	@DeleteMapping("/{id}")
	public Long deletePedido(@PathVariable Long id) {
		pedidoRepository.delete(id);
		return id;
	}

	@GetMapping("/test")
	public Pedido test() {
		return Pedido.builder()
				.id((long) 1)
				.idCliente((long) 1)
				.fechaPedido("2022-08-05 09:16:20")
				.fechaRegistro("2022-08-05 14:10:35")
				.build();
		
	}
}
