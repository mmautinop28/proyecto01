package pe.com.avicola.java.ms.avi.seguridad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.seguridad.entity.ClienteEntity;


@Repository
public interface 	ClienteRepository 
					extends JpaRepository<ClienteEntity, Integer>,
							PagingAndSortingRepository<ClienteEntity, Integer> {
	
	@Query("SELECT c FROM ClienteEntity c where c.estado=1")
	public List<ClienteEntity> findAllActivos();
	
	@Query("SELECT c FROM ClienteEntity c where c.razonSocialCliente like :nombre")
	public List<ClienteEntity> findLikeNombre(@Param("nombre") String nombre);
	
	@Query("SELECT c FROM ClienteEntity c where c.razonSocialCliente=:nombre")
	public ClienteEntity findByNombre(@Param("nombre") String nombre);
		
}
