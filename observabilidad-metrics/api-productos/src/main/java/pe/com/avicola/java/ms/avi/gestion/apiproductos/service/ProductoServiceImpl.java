package pe.com.avicola.java.ms.avi.gestion.apiproductos.service;

import java.util.List;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.avi.gestion.apiproductos.entity.Producto;
import pe.com.avicola.java.ms.avi.gestion.apiproductos.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	private ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository=productoRepository;
	}

	@Override
	public List<Producto> findAll() {

		return productoRepository.findAllCustom();
	}

	@Override
	public Producto insert(Producto producto) {
		return productoRepository.save(producto);
	}

}
