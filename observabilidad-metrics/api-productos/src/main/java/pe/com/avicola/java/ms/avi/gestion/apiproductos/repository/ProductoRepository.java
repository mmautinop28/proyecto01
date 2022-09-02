package pe.com.avicola.java.ms.avi.gestion.apiproductos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.avicola.java.ms.avi.gestion.apiproductos.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("select p from Producto p where p.estado=1")					//JPQL ->SQL
	List<Producto> findAllCustom();
}
