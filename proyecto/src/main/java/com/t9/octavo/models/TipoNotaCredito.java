
package com.t9.octavo.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


	
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
	
	
	
	public TipoNotaCredito() {
		
	}
	

	public TipoNotaCredito(Long id, String detalle) {
		this.id = id;
		this.detalle = detalle;
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

	
	
}
