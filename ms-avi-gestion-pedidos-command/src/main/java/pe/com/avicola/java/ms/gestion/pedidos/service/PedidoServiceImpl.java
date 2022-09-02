package pe.com.avicola.java.ms.gestion.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;
import pe.com.avicola.java.ms.gestion.pedidos.repository.PedidoRepository;
import pe.com.avicola.java.ms.gestion.pedidos.service.exception.ServiceException;
import reactor.core.publisher.Mono;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Mono<Orden> save(Orden orden) throws ServiceException {
		try {
			return pedidoRepository.save(orden);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
