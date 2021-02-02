package com.t9.octavo.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection = "choferDespacho")
public class ChoferDespacho {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@NotBlank
	@Indexed(unique = true)
    @Size(max=50)
	@Field("nombreChoferDespacho")
	private String nombre;
	
	@NotBlank
    @Size(max=15)
	@Field("placaChoferDespacho")
	private String placa;
	
	public ChoferDespacho() {
		
	}

	public ChoferDespacho(Long id,String nombre,String placa) {
		this.id = id;
		this.nombre = nombre;
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
