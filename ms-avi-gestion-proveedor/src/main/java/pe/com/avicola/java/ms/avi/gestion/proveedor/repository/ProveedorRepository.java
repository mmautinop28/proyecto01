package pe.com.avicola.java.ms.avi.gestion.proveedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.proveedor.entity.ProveedorEntity;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{

}
