package pe.com.avicola.java.ms.gestion.pedidos.document;


import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "TBL_AVI_PEDIDO")
public class Orden implements Serializable {

	@Id
    private String id= UUID.randomUUID().toString();

	@Field("idPedido")
	private Long idPedido;

	@Field("fechaPedido")
	private String fechaPedido;

	@Field("fechaRegistro")
	private String fechaRegistro;
	
	@Field("estadoPedido")
	private Long estadoPedido;
	
	@Field("activoPedido")
	private Long activoPedido;

	@Field("idCliente")
	private Long idCliente;
	
	@Field("rucCliente")
	private Long rucCliente;
	
	@Field("razonSocialCliente")
	private String razonSocialCliente;
			
}
