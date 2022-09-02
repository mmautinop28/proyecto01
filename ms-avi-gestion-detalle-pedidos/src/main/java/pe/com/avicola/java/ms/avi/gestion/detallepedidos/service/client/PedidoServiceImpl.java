package pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PedidoServiceImpl implements PedidoService{

	
	private DiscoveryClient discoveryClient;
	
	private RestTemplate 	restTemplate;
	
	private String url="ms-avi-gestion-pedidos";
	
	public PedidoServiceImpl (RestTemplate restTemplate,DiscoveryClient discoveryClient) {
		this.discoveryClient=discoveryClient;
		this.restTemplate = restTemplate;
		//log.info("this.getURI() "+this.getURI());
		
	}

	@Override
	public PedidoDTO findById(Long id) throws ClientException {
		log.info("this.getURI Pedido " + this.getURI());
		System.out.println("idPedido ---> " + id);
		System.out.println("this.getURI Pedido " + this.getURI() + "/v1/pedidos/" + id);
		ResponseEntity<PedidoDTOResponse> rEPedidoDTO=restTemplate.getForEntity(this.getURI()+"/v1/pedidos/"+id, PedidoDTOResponse.class);
	
		if (!Objects.isNull(rEPedidoDTO)) {
			return rEPedidoDTO.getBody().getData();
		}
		return null;
	}
	
	
	private String getURI() {
		if (Objects.isNull(discoveryClient)) {
			log.info("discoveryClient is null");
			return "";
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(url);

		if (Objects.isNull(instances) || instances.isEmpty()) return "not found";
		System.out.println(instances.get(0).getHost());
		String uri=instances.get(0).getUri().toString();		
		log.info("uri" +uri);
		return uri;
	}

}
