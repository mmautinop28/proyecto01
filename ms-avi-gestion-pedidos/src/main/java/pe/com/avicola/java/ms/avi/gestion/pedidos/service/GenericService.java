package pe.com.avicola.java.ms.avi.gestion.pedidos.service;

import java.util.List;
import java.util.Optional;

import pe.com.avicola.java.ms.avi.gestion.pedidos.service.exception.ServiceException;

public interface GenericService<T> {
	
	List<T> findLike(T t) throws ServiceException;

	Optional<T> findById(T t) throws ServiceException;
	
	T save(T t) throws ServiceException;
}
