package pe.com.avicola.java.ms.avi.gestion.proveedor.service.service;

import java.util.List;
import java.util.Optional;

import pe.com.avicola.java.ms.avi.gestion.proveedor.service.exception.ServiceException;

public interface GenericeService<T> {
	
	List<T> findByLike(T t) throws ServiceException;
	
	Optional<T> findById(Long id)throws ServiceException;

}
