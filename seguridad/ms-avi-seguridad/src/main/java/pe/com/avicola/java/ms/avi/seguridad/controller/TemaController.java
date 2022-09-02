package pe.com.avicola.java.ms.avi.seguridad.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.avicola.java.ms.avi.seguridad.entity.TemaEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.TemaService;

@RestController
@RequestMapping("/temas/v1/")
public class TemaController {

	@Autowired
	private TemaService temaService;

	@GetMapping
	public ResponseEntity<Response> listar() {
		try {
			Object lst = temaService.findAll(null);
			if (lst != null) {
				
				List<TemaEntity> lstTemaEntity	=((List<TemaEntity>)lst);
				
				if (lstTemaEntity.size()>0) {
					return ResponseEntity.ok(
							Response.builder()
							.codigo(1)
							.descripcion("Existen "+ lstTemaEntity.size() +" temas en la base de datos")
							.respuesta(lst)
							.build()
							);	
				}
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
					Response.builder()
					.codigo(0)
					.descripcion("No existen temas en la base de datos")
					.respuesta(null)
					.build()
					);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/by-nombre")
	public ResponseEntity<Object> findLikeNombre(@RequestParam String nombre) {
		try {
			Object lst = temaService.findLikeNombre(nombre);
			if (lst != null) {
				return ResponseEntity.ok(lst);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	


	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarXId(@PathVariable Integer id) {
		if (id <= 0) {
			return ResponseEntity.badRequest().build();
		}
		try {
			TemaEntity temaEntity = new TemaEntity();
			temaEntity.setId(id);
			Object obj = temaService.findById(temaEntity);
			if (obj != null) {
				return ResponseEntity.ok(obj);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Response> insert(@RequestBody TemaEntity temaEntity) {

		System.out.println("temaEntity " + temaEntity);
		if (temaEntity == null) {
			return ResponseEntity.ok(new Response(0, "El tema es requerido",null));
		}

		if (temaEntity.getNombre().trim().length() < 2) {
			return ResponseEntity
					.ok(new Response(0, "El nombre del tema es requerido y debe ser mayor a 2 caracteres",null));
		}
		try {
			
			Object obj = temaService.save(temaEntity);
			if (obj != null) {
				
				return ResponseEntity.ok(new Response(1, "Exito al realizar el registro del tema",obj));
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody TemaEntity temaEntity) {
		try {
			TemaEntity prmTemaEntity = new TemaEntity();
			prmTemaEntity.setId(id);
			Optional<Object> ret = (Optional<Object>) temaService.findById(prmTemaEntity);
			System.out.println("ret " + ret);
			if (ret != null && ret.isPresent()) {
				temaEntity.setId(id);
				Object obj = temaService.save(temaEntity);
				if (obj != null) {
					return ResponseEntity.ok(obj);
				} else {
					return ResponseEntity.noContent().build();
				}
			} else {
				return ResponseEntity.notFound().build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable Integer id) {

		try {
			TemaEntity temaEntity = new TemaEntity();
			temaEntity.setId(id);
			Object obj = temaService.delete(temaEntity);
			if (obj != null) {
				return ResponseEntity.ok(obj);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
