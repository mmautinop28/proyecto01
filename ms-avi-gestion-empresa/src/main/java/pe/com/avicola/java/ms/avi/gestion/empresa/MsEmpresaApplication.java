package pe.com.avicola.java.ms.avi.gestion.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsEmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmpresaApplication.class, args);
	}

}
