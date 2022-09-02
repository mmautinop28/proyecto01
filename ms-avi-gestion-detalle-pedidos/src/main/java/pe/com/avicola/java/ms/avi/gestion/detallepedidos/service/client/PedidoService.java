package pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client;

public interface PedidoService {

	PedidoDTO findById(Long id) throws ClientException; 
}
