package pe.com.avicola.java.ms.avi.gestion.detallepedidos.entity;


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
@Table(name = "TBL_AVI_DET_PEDIDO")
@Entity(name = "DetallePedidoEntity")
public class DetallePedidoEntity extends GenericEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetallePedido")
    @SequenceGenerator(sequenceName = "SEQ_DETALLE_PEDIDO", allocationSize = 1, name = "seqDetallePedido")
	@Column(name="N_ID_DET_PEDIDO")
	private Long id;
	
	@Column(name="N_ID_PEDIDO")
	private Long idPedido;
	
	@Column(name="N_NRO_ITEM")
	private Long nroItem;
	
	@Column(name="N_ID_PROD")
	private Long idProducto;
	
	@Column(name="N_CANT_DET_PEDIDO")
	private Long cantidadProducto;
	
	@Column(name="N_CANT_TOT_DET_PEDIDO")
	private Long cantidadTotalProducto;
	
	@Column(name="N_PUB_DET_PEDIDO")
	private int indPublicado;
	
	@Column(name = "D_FEC_CRE")
	private String fechaRegistro;

}
