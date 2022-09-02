package pe.com.avicola.java.ms.avi.gestion.clientes.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteDTO implements Serializable{
		  
	private static final long serialVersionUID = -9807309035903996L;
	private Long id;
	
	private Long rucCliente;
	
	private Long dniCliente;
	
	private String razonSocialCliente;
			
	private String direccionCliente;
	
	private String telefonoCliente;

	private String emailCliente;
	
	private String representanteCliente;
	
	private Long idTipoCliente;
		
	private Long estado;
	
	private Long activo;
}
