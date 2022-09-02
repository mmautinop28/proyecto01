package pe.com.avicola.java.ms.avi.gestion.proveedor.entity;

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
@Table(name = "TBL_AVI_PROVEEDOR")
public class ProveedorEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "N_ID_PROV")
	  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProveedor")
	    @SequenceGenerator(sequenceName = "SEQ_PROVEEDOR", allocationSize = 1, name = "seqProveedor")
		private Long id;
		
		@Column(name="N_TIPO_PROV")
		private Long idTipoProveedor;
				
		@Column(name="C_RUC_PROV")
		private Long rucProveedor;
		
		@Column(name="C_DNI_PROV")
		private String dniProveedor;
		
		@Column(name="C_RAZSOC_PROV")
		private String razonSocialProveedor;
		
		@Column(name="C_DIR_PROV")
		private String direccionProveedor;

		@Column(name="C_TEL_PROV")
		private String telefonoProveedor;
		
		@Column(name="C_EMAIL_PROV")
		private String emailProveedor;
		
		@Column(name="C_REP_PROV")
		private String representanteProveedor;
			
		@Column(name="N_EST_PROV")
		private int estado;
		
		@Column(name="N_ACT_PROV")
		private int activo;

}
