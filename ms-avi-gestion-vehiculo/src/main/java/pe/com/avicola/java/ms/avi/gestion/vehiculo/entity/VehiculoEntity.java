package pe.com.avicola.java.ms.avi.gestion.vehiculo.entity;

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
@Table(name = "TBL_AVI_VEHICULO")
public class VehiculoEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "N_ID_VEHI")
	  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVehiculo")
	    @SequenceGenerator(sequenceName = "SEQ_VEHICULO", allocationSize = 1, name = "seqVehiculo")
		private Long id;
			
		@Column(name="C_MAR_VEHI")
		private Long idMarcaVehiculo;
		
		@Column(name="C_MOD_VEHI")
		private Long idModeloVehiculo;
		
		@Column(name="C_PLA_VEHI")
		private String placaVehiculo;

		@Column(name="N_CIL_VEHI")
		private Long cilindradaVehiculo;

		@Column(name="N_EJE_VEHI")
		private Long ejeVehiculo;

		@Column(name="N_PES_VEHI")
		private Long pesoVehiculo;

		@Column(name="N_ALT_VEHI")
		private Long alturaVehiculo;

		@Column(name="N_EST_VEHI")
		private int estado;
		
		@Column(name="N_ACT_VEHI")
		private int activo;
}
