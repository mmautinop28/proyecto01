package pe.com.avicola.java.ms.avi.gestion.pedidos.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	private Integer code;
	private String  message;
}
