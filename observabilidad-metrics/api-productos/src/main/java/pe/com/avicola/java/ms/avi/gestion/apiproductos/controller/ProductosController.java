package pe.com.avicola.java.ms.avi.gestion.apiproductos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.avicola.java.ms.avi.gestion.apiproductos.entity.Producto;
import pe.com.avicola.java.ms.avi.gestion.apiproductos.service.ProductoService;

@RestController
@RequestMapping("/produtos")
public class ProductosController {
	
	@Autowired
	private ProductoService productoService; 

	@GetMapping
	public List<Producto> findByLike() {
		return productoService.findAll();
	}

	@PostMapping
	public Producto insert(@RequestBody Producto cliente) {
		try {
			return productoService.insert(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
