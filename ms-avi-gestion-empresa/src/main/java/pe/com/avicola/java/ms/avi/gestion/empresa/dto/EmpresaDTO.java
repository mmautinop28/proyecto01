package pe.com.avicola.java.ms.avi.gestion.empresa.dto;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EmpresaDTO implements Serializable{
		  
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long rucEmpresa;
	
	private String nombreEmpresa;
	
	private String direccionEmpresa;

	private String telefonoEmpresa;
	
	private String emailEmpresa;
	
	private String representanteEmpresa;
		
	private int estado;
	
	private int activo;


}
