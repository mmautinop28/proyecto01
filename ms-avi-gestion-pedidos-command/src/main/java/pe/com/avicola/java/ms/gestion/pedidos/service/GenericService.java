package pe.com.avicola.java.ms.gestion.pedidos.service;

import pe.com.avicola.java.ms.gestion.pedidos.service.exception.ServiceException;
import reactor.core.publisher.Mono;

public interface GenericService<T> {
	
	Mono<T> save(T t) throws ServiceException;

}
