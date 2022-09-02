package pe.com.avicola.java.ms.avi.seguridad.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
    	http
        .authorizeRequests()
         //.antMatchers(HttpMethod.POST, "/usuario/v1/**")
         //.hasRole("ADMIN")
         .anyRequest()
         .authenticated();
    }
}