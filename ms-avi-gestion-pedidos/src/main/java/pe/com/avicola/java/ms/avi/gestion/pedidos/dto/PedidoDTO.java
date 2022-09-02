package pe.com.avicola.java.ms.avi.gestion.pedidos.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.avicola.java.ms.avi.gestion.pedidos.service.client.ClienteDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","idCliente","fechaRegistro","fechaPedido"})
public class PedidoDTO extends GenericDTO{

	private Long id;
	
	private Long idCliente;
	
	private String fechaRegistro;
	
	private String fechaPedido;

	private ClienteDTO cliente;
	
	
}
