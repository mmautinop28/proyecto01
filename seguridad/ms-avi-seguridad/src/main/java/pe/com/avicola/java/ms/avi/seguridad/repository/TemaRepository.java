package pe.com.avicola.java.ms.avi.seguridad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.seguridad.entity.TemaEntity;


@Repository
public interface 	TemaRepository 
					extends JpaRepository<TemaEntity, Integer>,
							PagingAndSortingRepository<TemaEntity, Integer> {
	
	@Query("SELECT t FROM TemaEntity t where t.estado=1")
	public List<TemaEntity> findAllActivos();
	
	@Query("SELECT t FROM TemaEntity t where t.nombre like :nombre")
	public List<TemaEntity> findLikeNombre(@Param("nombre") String nombre);
	
	@Query("SELECT t FROM TemaEntity t where t.nombre=:nombre")
	public TemaEntity findByNombre(@Param("nombre") String nombre);
		
}
