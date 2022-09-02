package pe.com.avicola.java.ms.gestion.pedidos.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;

@Repository
public interface PedidoRepository  extends ReactiveMongoRepository<Orden, String>{

	
}
