package pe.com.avicola.java.ms.avi.gestion.clientes.entity;

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
@Table(name = "TBL_AVI_CLIENTE")
public class ClienteEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "N_ID_CLIENTE")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
	    @SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqCliente")
		private Long id;
	  
		
		@Column(name="C_RUC_CLIENTE")
		private Long rucCliente;
		
		@Column(name="C_DNI_CLIENTE")
		private Long dniCliente;
		
		@Column(name="C_RAZSOC_CLIENTE")
		private String razonSocialCliente;
				
		@Column(name="C_DIR_CLIENTE")
		private String direccionCliente;
		
		@Column(name="C_TEL_CLIENTE")
		private String telefonoCliente;

		@Column(name="C_EMAIL_CLIENTE")
		private String emailCliente;
		
		@Column(name="C_REP_CLIENTE")
		private String representanteCliente;
		
		@Column(name="N_ID_TIP_CLIENTE")
		private Long idTipoCliente;
			
		@Column(name="N_EST_CLIENTE")
		private Long estado;
		
		@Column(name="N_ACT_CLIENTE")
		private Long activo;

}
