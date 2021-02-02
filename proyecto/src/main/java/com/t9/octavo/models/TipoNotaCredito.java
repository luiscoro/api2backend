
package com.t9.octavo.models;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

	
@Document (collection = "tipoNotaCredito")
public class TipoNotaCredito {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@NotBlank
    @Size(max=30)
	@Field("detalleTipoNotaCredito")
	private String detalle;
	
	private List<NotaCredito> notas;
	
	
	public TipoNotaCredito() {
		
	}
	

	public TipoNotaCredito(Long id, String detalle, List<NotaCredito> notas) {
		this.id = id;
		this.detalle = detalle;
		this.notas = notas;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<NotaCredito> getNotas() {
		return notas;
	}

	public void setNotas(List<NotaCredito> notas) {
		this.notas = notas;
	}
	
	 @Override
	    public String toString() {
	      ObjectMapper mapper = new ObjectMapper();
	      
	      String jsonString = "";
	    try {
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      jsonString = mapper.writeValueAsString(this);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    
	      return jsonString;
	    }
	
}
