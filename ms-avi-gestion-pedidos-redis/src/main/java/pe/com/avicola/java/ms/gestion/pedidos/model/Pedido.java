package pe.com.avicola.java.ms.gestion.pedidos.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long idCliente;
	
	private String fechaPedido;
	
	private String fechaRegistro;	

}
