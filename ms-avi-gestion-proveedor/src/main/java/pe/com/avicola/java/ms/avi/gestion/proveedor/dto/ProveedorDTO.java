package pe.com.avicola.java.ms.avi.gestion.proveedor.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ProveedorDTO implements Serializable{
		  
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long idTipoProveedor;
			
	private Long rucProveedor;
	
	private String dniProveedor;
	
	private String razonSocialProveedor;
	
	private String direccionProveedor;

	private String telefonoProveedor;
	
	private String emailProveedor;
	
	private String representanteProveedor;
		
	private int estado;
	
	private int activo;

}
