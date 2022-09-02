package pe.com.avicola.java.ms.avi.tracer11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TracerDemo11Application {

	public static void main(String[] args) {
		SpringApplication.run(TracerDemo11Application.class, args);
	}
	@Bean
	public RestTemplate getTestTemplate() {
		return new RestTemplate();
	}
}
