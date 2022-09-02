package pe.com.avicola.java.ms.avi.seguridad.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Response {

	private int codigo;
	
	private String descripcion;
	
	private Object respuesta;
	
}
