package pe.com.avicola.java.ms.avi.gestion.producto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_AVI_PRODUCTO")
public class ProductoEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

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
