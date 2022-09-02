package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;

import pe.com.avicola.java.ms.avi.seguridad.entity.TemaEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

public interface TemaService extends GenericoService<TemaEntity>{

	public List<TemaEntity> findLikeNombre(String nombre) throws ServiceException;
	
}
