package pe.com.avicola.java.ms.avi.tracer11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demos-1-1")
public class TracerDemo11 {

	private RestTemplate template;
	
	public TracerDemo11(RestTemplate template) {
		this.template=template;
	}
	
	@GetMapping("/{tipo}")
	public String demo(@PathVariable("tipo") Integer tipo) {
		log.info("demos-1-1...");
		String res=null;
		if (tipo==1) {
			res=this.template.getForObject("http://localhost:8100/demos-1-1-1/"+tipo, String.class);
		}else {
			res=this.template.getForObject("http://localhost:8101/demos-1-1-2/"+tipo, String.class);
		}	
		return res;
	}
}
