package pe.com.avicola.java.ms.avi.gestion.empresa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Configuration
public class GlobalConfiguration {

	public GlobalConfiguration() {
		
	}
	
	@Bean
	public JsonMapper getJsonMapper() {
		return new JsonMapper();
	}

}
