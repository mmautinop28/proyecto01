package pe.com.avicola.java.ms.avi.tracer1;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demos")
public class TracerDemo1 {
	
	private RestTemplate template;
	
	public TracerDemo1(RestTemplate template) {
		this.template=template;
	}
	
	@GetMapping("/{tipo}")
	public String demo(@PathVariable("tipo") Integer tipo) {
		System.out.println("tipo --> " + tipo);
		String res=this.template.getForObject("http://localhost:8099/demos-1-1/"+tipo,String.class);
		System.out.println("res --> " + res);
		return res;
	}
	
	@GetMapping("/demo1")
	public String demo1() {
		String message = "Spring Boot Demo 1 " + LocalDate.now();
		log.info(message);
		return message;
	}
	
}
