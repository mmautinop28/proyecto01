package pe.com.avicola.java.ms.avi.gestion.empresa.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.avicola.java.ms.avi.gestion.empresa.dto.EmpresaDTO;
import pe.com.avicola.java.ms.avi.gestion.empresa.service.EmpresaService;

import static pe.com.avicola.java.ms.avi.gestion.empresa.commons.GlobalConstants.API_EMPRESA;
import static pe.com.avicola.java.ms.avi.gestion.empresa.commons.GlobalConstants.COD_CONSULTA_EXITO;
import static pe.com.avicola.java.ms.avi.gestion.empresa.commons.GlobalConstants.MSG_CONSULTA_EXITO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(API_EMPRESA)
public class EmpresaController {

	private EmpresaService empresaService;

	public EmpresaController(EmpresaService empresaService) {
		super();
		this.empresaService = empresaService;
	}

	
	@GetMapping
	public ResponseEntity<Response>  findByLike(){
		try {
			List<EmpresaDTO> lstEmpresaDTO= this.empresaService.findByLike(null);
			if (lstEmpresaDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(
					Response
					.builder()
					.message(Message.builder().code(COD_CONSULTA_EXITO).message(MSG_CONSULTA_EXITO).build())
					.data(lstEmpresaDTO)
					.build());
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	}
	
	/*
	@GetMapping
	public List<ProductoDTO>  findByLike() throws ServiceException{
		return this.productoService.findByLike(null);
	}*/
}
