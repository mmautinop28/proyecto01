package pe.com.avicola.java.ms.avi.gestion.apiproductos.service;

import java.util.List;

import pe.com.avicola.java.ms.avi.gestion.apiproductos.entity.Producto;

public interface ProductoService {

	List<Producto> findAll();
	
	Producto insert(Producto producto);
	
}
