package pe.com.avicola.java.ms.avi.gestion.detallepedidos.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client.PedidoDTO;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@JsonPropertyOrder(value = {"id","idPedido","nroItem","idProducto","cantidadProducto","cantidadTotalProducto","indPublicado","fechaRegistro"})
public class DetallePedidoDTO extends GenericDTO{

	private Long id;
	
	private Long idPedido;
	
	private Long nroItem;
	
	private Long idProducto;
	
	private Long cantidadProducto;
	
	private Long cantidadTotalProducto;
	
	private int indPublicado;
	
	private String fechaRegistro;

	private PedidoDTO pedido;
	
}
