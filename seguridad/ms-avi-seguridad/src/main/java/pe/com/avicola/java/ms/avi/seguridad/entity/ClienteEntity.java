package pe.com.avicola.java.ms.avi.seguridad.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "ClienteEntity")
@Table(name = "TBL_AVI_CLIENTE")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class ClienteEntity {
	
	private static final long serialVersionUID = -3585004832721879188L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
	@SequenceGenerator(name = "SEQ_CLIENTE", allocationSize = 1, sequenceName = "SEQ_CLIENTE")
	@Column(name = "N_ID_CLIENTE")
	private Integer id;
	
	
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
	private int estado;
	
	@Column(name="N_ACT_CLIENTE")
	private int activo;
	
	/*
	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TALLER")
	@JsonIgnore
	private TallerEntity tallerEntity;
*/

}
