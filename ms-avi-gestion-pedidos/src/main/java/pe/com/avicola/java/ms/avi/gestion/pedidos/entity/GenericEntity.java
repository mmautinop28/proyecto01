package pe.com.avicola.java.ms.avi.gestion.pedidos.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class GenericEntity {

	@Column(name = "N_EST_PEDIDO")
	@Builder.Default
	private String estado="1";	
	
	@Column(name = "N_ACT_PEDIDO")
	@Builder.Default
	private String activo="1";	
}

