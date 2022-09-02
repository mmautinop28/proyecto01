package pe.com.avicola.java.ms.avi.gestion.empresa.entity;

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
@Table(name = "TBL_AVI_EMPRESA")
public class EmpresaEntity implements Serializable{
		  
	private static final long serialVersionUID = -2170897015344177815L;

		@Id
	  	@Column(name = "N_ID_EMP")
	  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmpresa")
	    @SequenceGenerator(sequenceName = "SEQ_EMPRESA", allocationSize = 1, name = "seqEmpresa")
		private Long id;
		
		@Column(name="C_RUC_EMP")
		private Long rucEmpresa;
		
		@Column(name="C_NOM_EMP")
		private String nombreEmpresa;
		
		@Column(name="C_DIR_EMP")
		private String direccionEmpresa;

		@Column(name="C_TEL_EMP")
		private String telefonoEmpresa;
		
		@Column(name="C_EMAIL_EMP")
		private String emailEmpresa;
		
		@Column(name="C_REP_EMP")
		private String representanteEmpresa;
			
		@Column(name="N_EST_EMP")
		private int estado;
		
		@Column(name="N_ACT_EMP")
		private int activo;

}
