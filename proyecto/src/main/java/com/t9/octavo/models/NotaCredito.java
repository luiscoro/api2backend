package com.t9.octavo.models;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
	
@Document (collection = "notaCredito")
public class NotaCredito {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@Field("fechaNotaCredito")
	private Date fecha = new Date();
	
	@NotBlank
	@Size(max=30)
    @Field("responsableNotaCredito")
	private String responsable;
	
	@Size(max=200)
	@Field("observacionesNotaCredito")
	private String observaciones;
	
	@Field("valorNotaCredito")
	public double valor;
	
	private Set<NotaCredito> notaCredito;
	
	public NotaCredito() {
		
	}

	public NotaCredito(Long id, Date fecha,String responsable,String observaciones, double valor) {
		this.id = id;
		this.fecha = fecha;
		this.responsable = responsable;
		this.observaciones = observaciones;
		this.valor = valor;
		
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
	
	public String getResponsable() {
		return responsable;
	}
	
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public float getTotal() {
		float total=0;
		for(NotaCredito nc: this.notaCredito) {
			total += nc.valor;
		}
		
		return 0;
	}
	
	
	
}
