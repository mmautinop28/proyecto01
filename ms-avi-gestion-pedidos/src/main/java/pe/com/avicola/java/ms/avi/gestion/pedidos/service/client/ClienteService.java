package pe.com.avicola.java.ms.avi.gestion.pedidos.service.client;

public interface ClienteService {

	ClienteDTO findById(Long id) throws ClientException; 
}
