package pe.com.avicola.java.ms.avi.gestion.detallepedidos.service.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.avicola.java.ms.avi.gestion.detallepedidos.commons.Message;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTOResponse {
	private Message 	message;
	private PedidoDTO 	data;
}
