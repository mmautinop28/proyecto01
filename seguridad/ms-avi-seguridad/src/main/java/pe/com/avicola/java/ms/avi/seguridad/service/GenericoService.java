package pe.com.avicola.java.ms.avi.seguridad.service;

import pe.com.avicola.java.ms.avi.seguridad.service.exception.ServiceException;

public interface GenericoService<T> {

	public Object findAll(T t) throws ServiceException;
	
	public Object findById(T t) throws ServiceException;
	
	public Object save(T t) throws ServiceException;
	
	public Object delete(T t) throws ServiceException;
	
}
