package pe.com.avicola.java.ms.avi.gestion.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@RefreshScope
@SpringBootApplication
public class MSAviGestionOrderProducerApp {

	public static void main(String[] args) {
		SpringApplication.run(MSAviGestionOrderProducerApp.class, args);
	}

}
