package pe.com.avicola.java.ms.avi.gestion.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.gestion.empresa.entity.EmpresaEntity;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long>{

}
