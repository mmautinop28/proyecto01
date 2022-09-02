package pe.com.avicola.java.ms.avi.tracer112;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/demos-1-1-2")
public class TracerDemo112 {

	@GetMapping("/{tipo}")
	public String demo(@PathVariable("tipo") Integer tipo) {
		log.info("demos 1.1.2...x");
		return "Tracer 1.1.2 -> "+ 20*tipo;
	}

}
