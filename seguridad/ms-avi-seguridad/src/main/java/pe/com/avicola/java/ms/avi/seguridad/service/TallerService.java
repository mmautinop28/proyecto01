package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;

import pe.com.avicola.java.ms.avi.seguridad.entity.TallerEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

public interface TallerService extends GenericoService<TallerEntity>{

	public List<TallerEntity> findLikeNombre(String nombre) throws ServiceException;
	
	public TallerEntity findByNombre(String nombre) throws ServiceException;
			
}
