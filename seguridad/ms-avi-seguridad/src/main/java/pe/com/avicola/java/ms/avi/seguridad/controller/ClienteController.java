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

import pe.com.avicola.java.ms.avi.seguridad.entity.ClienteEntity;
import pe.com.avicola.java.ms.avi.seguridad.service.ClienteService;

@RestController
@RequestMapping("/clientes/v1/")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Response> listar() {
		try {
			Object lst = clienteService.findAll(null);
			if (lst != null) {
				
				List<ClienteEntity> lstClienteEntity = ((List<ClienteEntity>)lst);
				System.out.println("lstClienteEntity.size ----> " + lstClienteEntity.size());
				if (lstClienteEntity.size()>0) {
					return ResponseEntity.ok(
							Response.builder()
							.codigo(1)
							.descripcion("Existen " + lstClienteEntity.size() + " clientes en la base de datos")
							.respuesta(lst)
							.build()
							);	
				}
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
					Response.builder()
					.codigo(0)
					.descripcion("No existen clientes en la base de datos")
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
			Object lst = clienteService.findLikeNombre(nombre);
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
			ClienteEntity clienteEntity = new ClienteEntity();
			clienteEntity.setId(id);
			Object obj = clienteService.findById(clienteEntity);
			if (obj != null) {
				return ResponseEntity.ok(obj);
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<Response> insert(@RequestBody ClienteEntity clienteEntity) {

		System.out.println("clienteEntity " + clienteEntity);
		if (clienteEntity == null) {
			return ResponseEntity.ok(new Response(0, "El cliente es requerido",null));
		}

		if (clienteEntity.getRazonSocialCliente().trim().length() < 2) {
			return ResponseEntity
					.ok(new Response(0, "La razón social es requerido y debe ser mayor a 2 caracteres",null));
		}
		try {
			
			Object obj = clienteService.save(clienteEntity);
			if (obj != null) {
				
				return ResponseEntity.ok(new Response(1, "Exito al realizar el registro del cliente",obj));
			}
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ClienteEntity clienteEntity) {
		try {
			ClienteEntity prmClienteEntity = new ClienteEntity();
			prmClienteEntity.setId(id);
			Optional<Object> ret = (Optional<Object>) clienteService.findById(prmClienteEntity);
			System.out.println("ret " + ret);
			if (ret != null && ret.isPresent()) {
				clienteEntity.setId(id);
				Object obj = clienteService.save(clienteEntity);
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
			ClienteEntity clienteEntity = new ClienteEntity();
			clienteEntity.setId(id);
			Object obj = clienteService.delete(clienteEntity);
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
