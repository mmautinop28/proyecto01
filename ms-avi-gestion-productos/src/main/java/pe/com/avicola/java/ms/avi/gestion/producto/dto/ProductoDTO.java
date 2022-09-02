package pe.com.avicola.java.ms.avi.gestion.producto.dto;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class ProductoDTO implements Serializable{
		  
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nombreProducto;
	
	private Long idUnidadMedidaProducto;
	
	private Long idTipoProducto;
	
	private Long estado;


}
