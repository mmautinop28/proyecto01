package pe.com.avicola.java.ms.avi.seguridad.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "TallerEntity")
@Table(name = "TALLER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler","temas" })
public class TallerEntity extends GenericoEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTaller")
	@SequenceGenerator(name = "seqTaller", allocationSize = 1, sequenceName = "SEQ_TALLER")
	@Column(name = "ID_TALLER")
	private Integer id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "DURACION")
	private byte duracion;
	// 
	@OneToMany(mappedBy = "tallerEntity",fetch=FetchType.LAZY,cascade= CascadeType.MERGE,orphanRemoval=false)
	private List<TemaEntity> temas;

	/*
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TallerEntity))
			return false;
		return id != null && id == ((TallerEntity) o).getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}*/

}
