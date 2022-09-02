package pe.com.avicola.java.ms.avi.gestion.vehiculo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsVehiculoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVehiculoApplication.class, args);
	}

}
