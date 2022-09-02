package pe.com.avicola.java.ms.avi.gestion.pedidos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=true)
@Table(name = "TBL_AVI_PEDIDO")
@Entity(name = "PedidoEntity")
public class PedidoEntity extends GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPedido")
    @SequenceGenerator(sequenceName = "SEQ_PEDIDO", allocationSize = 1, name = "seqPedido")
	@Column(name = "N_ID_PEDIDO")
	private Long id;
	
	@Column(name = "N_ID_CLIENTE")
	private Long idCliente;

	@Column(name = "D_FEC_PEDIDO")
	private String fechaPedido;

	@Column(name = "D_FEC_CRE")
	private String fechaRegistro;

}
