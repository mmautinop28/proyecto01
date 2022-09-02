package pe.com.avicola.java.ms.avi.gestion.pedidos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.pedidos.entity.PedidoEntity;

@Repository
public interface PedidoRepository  extends JpaRepository<PedidoEntity, Long>{

	@Query("select p from PedidoEntity p where p.estado='1'")
	List<PedidoEntity> getAllActivos();
	
}
