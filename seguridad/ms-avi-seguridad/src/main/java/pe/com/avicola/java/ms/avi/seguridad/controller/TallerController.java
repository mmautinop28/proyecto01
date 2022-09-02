package pe.com.avicola.java.ms.avi.seguridad.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.avicola.java.ms.avi.seguridad.entity.TallerEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.TallerService;

@RestController
@RequestMapping("/talleres/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TallerController {

	@Autowired
	private TallerService tallerService;

	@SuppressWarnings("unchecked")
	@GetMapping
	public ResponseEntity<Response> listar() {
		try {
			Object lst = tallerService.findAll(null);
			if (lst != null) {
				
				List<TallerEntity> lstTallerEntity	=((List<TallerEntity>)lst);
				
				if (lstTallerEntity.size()>0) {
					return ResponseEntity.ok(
							Response.builder()
							.codigo(1)
							.descripcion("Existen "+ lstTallerEntity.size() +" talleres en la base de datos")
							.respuesta(lst)
							.build()
							);	
				}
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					Response.builder()
					.codigo(0)
					.descripcion("No existen talleres en la base de datos")
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
			Object lst = tallerService.findLikeNombre(nombre);
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
			TallerEntity tallerEntity = new TallerEntity();
			tallerEntity.setId(id);
			Object obj = tallerService.findById(tallerEntity);
			if (obj != null) {
				return ResponseEntity.ok(obj);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Response> insert(@RequestBody TallerEntity tallerEntity) {

		System.out.println("tallerEntity " + tallerEntity);
		if (tallerEntity == null) {
			return ResponseEntity.ok(new Response(0, "El taller es requerido",null));
		}

		if (tallerEntity.getNombre().trim().length() < 2) {
			return ResponseEntity
					.ok(new Response(0, "El nombre del taller es requerido y debe ser mayor a 2 caracteres",null));
		}
		if (tallerEntity.getDescripcion().trim().length() < 2) {
			return ResponseEntity
					.ok(new Response(0, "La descripción del taller es requerido y debe ser mayor a 2 caracteres",null));
		}

		try {
			TallerEntity oTallerEntity = tallerService.findByNombre(tallerEntity.getNombre());
			System.out.println("oTallerEntity " + oTallerEntity);
			if (oTallerEntity != null) {
				return ResponseEntity.ok(new Response(0, "Ya existe un taller con el nombre ingresado",null));

			}
			Object obj = tallerService.save(tallerEntity);
			if (obj != null) {
				
				return ResponseEntity.ok(new Response(1, "Exito al realizar el registro del taller",obj));
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody TallerEntity tallerEntity) {
		try {
			TallerEntity prmTallerEntity = new TallerEntity();
			prmTallerEntity.setId(id);
			Optional<Object> ret = (Optional<Object>) tallerService.findById(prmTallerEntity);
			System.out.println("ret " + ret);
			if (ret != null && ret.isPresent()) {
				tallerEntity.setId(id);
				Object obj = tallerService.save(tallerEntity);
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
			TallerEntity tallerEntity = new TallerEntity();
			tallerEntity.setId(id);
			Object obj = tallerService.delete(tallerEntity);
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
