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

@Entity(name = "TemaEntity")
@Table(name = "TEMA")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","tallerEntity" })
public class TemaEntity extends GenericoEntity {
	
	private static final long serialVersionUID = -3585004832721879188L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTema")
	@SequenceGenerator(name = "seqTema", allocationSize = 1, sequenceName = "SEQ_TEMA")
	@Column(name = "ID_TEMA")
	private Integer id;

	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_TALLER")
	@JsonIgnore
	private TallerEntity tallerEntity;

	/*
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TallerEntity))
			return false;
		return id != null && id == ((TemaEntity) o).getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}*/
}
