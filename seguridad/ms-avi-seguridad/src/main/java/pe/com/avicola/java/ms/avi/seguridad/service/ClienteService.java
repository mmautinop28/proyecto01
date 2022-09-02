package pe.com.avicola.java.ms.avi.seguridad.service;

import java.util.List;

import pe.com.avicola.java.ms.avi.seguridad.entity.ClienteEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

public interface ClienteService extends GenericoService<ClienteEntity>{

	public List<ClienteEntity> findLikeNombre(String nombre) throws ServiceException;
	
}
