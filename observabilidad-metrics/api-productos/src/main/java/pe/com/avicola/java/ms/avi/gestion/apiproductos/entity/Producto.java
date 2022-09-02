package pe.com.avicola.java.ms.avi.gestion.apiproductos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TBL_AVI_PRODUCTO")
@Entity(name = "Producto")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="N_ID_PRODUCTO")
	private Long id;
	
	@Column(name="C_NOM_PRODUCTO")
	private String nombreProducto;
	
	@Column(name="C_UNIMED_PRODUCTO")
	private Long idUnidadMedidaProducto;
	
	@Column(name="N_TIPO_PRODUCTO")
	private Long idTipoProducto;
	
	@Column(name="N_EST_PRODUCTO")
	private Long estado;


}