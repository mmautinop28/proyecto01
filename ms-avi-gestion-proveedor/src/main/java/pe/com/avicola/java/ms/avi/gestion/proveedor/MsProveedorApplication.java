package pe.com.avicola.java.ms.avi.gestion.proveedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsProveedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProveedorApplication.class, args);
	}

}
