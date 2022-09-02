package pe.com.avicola.java.ms.avi.gestion.pedidos.service.client;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","rucCliente","dniCliente","razonSocialCliente","telefonoCliente","emailCliente","representanteCliente","idTipoCliente","estado","activo"})
public class ClienteDTO{

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
