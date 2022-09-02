package pe.com.avicola.java.ms.gestion.pedidos.document;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPedido;

	private String fechaPedido;

	private String fechaRegistro;
	
	private Long estadoPedido;
	
	private Long activoPedido;

	private Long idCliente;
	
	private Long rucCliente;
	
	private String razonSocialCliente;

}
