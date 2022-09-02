package pe.com.avicola.java.ms.avi.seguridad.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.com.avicola.java.ms.avi.seguridad.entity.TallerEntity;


@Repository
public interface 	TallerRepository 
					extends JpaRepository<TallerEntity, Integer>,
							PagingAndSortingRepository<TallerEntity, Integer> {

	//JpaRepository
	
	@Query("SELECT t FROM TallerEntity t where t.estado=1")
	public List<TallerEntity> findAllActivos();
	
	@Query("SELECT t FROM TallerEntity t where t.nombre like :nombre")
	public List<TallerEntity> findLikeNombre(@Param("nombre") String nombre);
	
	@Query("SELECT t FROM TallerEntity t where t.nombre=:nombre")
	public TallerEntity findByNombre(@Param("nombre") String nombre);
	
	/*
	 * PagingAndSortingRepository
	 */
	@Query("SELECT t FROM TallerEntity t where t.estado='1'")
	public Page<TallerEntity> findAllActivos(Pageable pageable);
	
	@Query("SELECT t FROM TallerEntity t where upper(t.nombre) like :nombre and t.estado='1'")
	public Page<TallerEntity> findAllActivos(@Param("nombre") String nombre,
											 Pageable pageable);
	
}
