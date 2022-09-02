package pe.com.avicola.java.ms.avi.gestion.empresa.controller;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Message {
	private Integer code;
	private String  message;
}
