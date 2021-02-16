package com.t9.octavo.models;
import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document (collection = "guiaRemisionDespacho")
public class GuiaRemisionDespacho {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Field("fechaGuiaRemisionDespacho")
	private Date fecha = new Date();
	
	@Size(max=500)
    @Field("descripcionMercaderia")
	private String descripcion;
	
	@Size(max=200)
    @Field("observacionGuiaRemisionDespacho")
	private String observaciones;
	
	@Field("nombreChofer")
	private String chofer;
	
	public GuiaRemisionDespacho() {
		
	}

	public GuiaRemisionDespacho(Long id, Date fecha, String descripcion,
			String observaciones, String chofer) {
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.observaciones = observaciones;
		this.chofer = chofer;
	}



	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public String getChofer() {
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}
	
}
