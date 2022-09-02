package pe.com.avicola.java.ms.avi.seguridad.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericoEntity implements Serializable{
	
	private static final long serialVersionUID = -329120328123105132L;
	
	@Column(name="ESTADO")
	protected String estado;
	
}
