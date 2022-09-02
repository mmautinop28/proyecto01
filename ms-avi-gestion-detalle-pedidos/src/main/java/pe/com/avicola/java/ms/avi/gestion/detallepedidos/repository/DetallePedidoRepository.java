package pe.com.avicola.java.ms.avi.gestion.detallepedidos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.detallepedidos.entity.DetallePedidoEntity;

@Repository
public interface DetallePedidoRepository  extends JpaRepository<DetallePedidoEntity, Long>{

	@Query("select dp from DetallePedidoEntity dp where dp.estado='1'")
	List<DetallePedidoEntity> getAllActivos();
	
}
