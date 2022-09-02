package pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","idCliente","fechaRegistro","fechaPedido"})
public class PedidoDTO{

	private Long id;
	
	private Long idCliente;
	
	private String fechaRegistro;
	
	private String fechaPedido;

}
