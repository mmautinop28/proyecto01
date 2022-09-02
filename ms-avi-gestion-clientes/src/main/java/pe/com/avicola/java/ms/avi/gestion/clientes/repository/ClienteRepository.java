package pe.com.avicola.java.ms.avi.gestion.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.clientes.entity.ClienteEntity;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
