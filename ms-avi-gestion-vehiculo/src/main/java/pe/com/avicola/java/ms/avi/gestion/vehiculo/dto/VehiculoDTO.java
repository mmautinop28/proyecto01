package pe.com.avicola.java.ms.avi.gestion.vehiculo.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class VehiculoDTO implements Serializable{
		  
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long idMarcaVehiculo;
	
	private Long idModeloVehiculo;
	
	private String placaVehiculo;

	private Long cilindradaVehiculo;

	private Long ejeVehiculo;

	private Long pesoVehiculo;

	private Long alturaVehiculo;

	private int estado;
	
	private int activo;

}
