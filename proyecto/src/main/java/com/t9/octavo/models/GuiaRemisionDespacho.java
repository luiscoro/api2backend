package com.t9.octavo.models;
import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document (collection = "guiaRemisionDespacho")
public class GuiaRemisionDespacho {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Field("fechaGuiaRemisionDespacho")
	private Date fecha = new Date();
	
	@Size(max=200)
    @Field("observacionGuiaRemisionDespacho")
	private String observaciones;
	
	public GuiaRemisionDespacho() {
		
	}

	public GuiaRemisionDespacho(Long id, Date fecha,String observaciones) {
		this.id = id;
		this.fecha = fecha;
		this.observaciones = observaciones;
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
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
