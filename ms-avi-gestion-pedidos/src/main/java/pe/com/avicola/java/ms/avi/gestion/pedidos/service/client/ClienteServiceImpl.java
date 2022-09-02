package pe.com.avicola.java.ms.avi.gestion.pedidos.service.client;

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
public class ClienteServiceImpl implements ClienteService{

	
	private DiscoveryClient discoveryClient;
	
	private RestTemplate 	restTemplate;
	
	private String url="ms-avi-gestion-clientes";
	
	//private String url_h="localhost:8082/v1/clientes";
	
	//private String url_r="lb://MS-VENTAS-GESTION-CLIENTES"
	
	
	
	public ClienteServiceImpl (RestTemplate restTemplate,DiscoveryClient discoveryClient) {
		this.discoveryClient=discoveryClient;
		this.restTemplate = restTemplate;
		//log.info("this.getURI() "+this.getURI());
		
	}

	@Override
	public ClienteDTO findById(Long id) throws ClientException {
		log.info("this.getURI() "+this.getURI());
		System.out.println("idcliente ---> " + id);
		System.out.println("this.getURI() "+this.getURI());
		ResponseEntity<ClienteDTOResponse> rEClienteDTO=restTemplate.getForEntity(this.getURI()+"/v1/clientes/"+id, ClienteDTOResponse.class);
	
		if (!Objects.isNull(rEClienteDTO)) {
			return rEClienteDTO.getBody().getData();
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
