package pe.com.avicola.java.ms.avi.gestion.empresa.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {

	private Message message;
	
	//@JsonIgnore
	private Object data;
	
	
}
