package pe.com.avicola.java.ms.avi.gestion.vehiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.vehiculo.entity.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Long>{

}
