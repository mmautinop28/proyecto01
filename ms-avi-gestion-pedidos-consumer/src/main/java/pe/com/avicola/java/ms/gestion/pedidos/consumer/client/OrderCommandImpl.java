package pe.com.avicola.java.ms.gestion.pedidos.consumer.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.gestion.pedidos.document.Orden;

@Slf4j
@Component
public class OrderCommandImpl implements OrderCommand{

	private DiscoveryClient discoveryClient;

	// Client
	private WebClient rest;

	//MS-AVI-GESTION-PEDIDOS-COMMAND
	private String uri = "ms-avi-gestion-pedidos-command";
	//private String ms_local="http://localhost:8085";

	public OrderCommandImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
		//this.rest = builder.baseUrl(ms_local + "/v1/pedidos-command").build();
		this.rest = builder.baseUrl(this.getURI() + "/v1/pedidos-command").build();
	}

	@Override
	public void enviar(Orden orden) {
		try {
			
			log.info("Pre post enviar command [{}]",orden);
			this.getURI();
			log.info("rest  [{}]",rest);
			rest.post()
	        .uri("")
	        .body(BodyInserters.fromValue(orden))
	        .retrieve()
	        .bodyToMono(Orden.class)
	        .subscribe(System.out::println);
			
			log.info("Post enviar -> command");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getURI() {
		List<ServiceInstance> instances = discoveryClient.getInstances(uri);
		System.out.println("getServices");
		discoveryClient.getServices().forEach(System.out::println);
		
		if (Objects.isNull(instances) || instances.isEmpty()) {
			log.info("instances is null");
			return null;
		}
		String uri = instances.get(0).getUri().toString();
		log.info("uri ->" + uri);
		return uri;
	}

}
