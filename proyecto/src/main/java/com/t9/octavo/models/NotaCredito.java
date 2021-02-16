package com.t9.octavo.models;
import javax.validation.constraints.Size;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import com.fasterxml.jackson.annotation.JsonFormat;
	
@Document (collection = "notaCredito")
public class NotaCredito {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Field("fechaNotaCredito")
	private Date fecha = new Date();
	
	@NotBlank
	@Size(max=30)
    @Field("responsableNotaCredito")
	private String responsable;
	
	@Field("valorNotaCredito")
	public double valor;
	
	
	@Size(max=200)
	@Field("observacionesNotaCredito")
	private String observaciones;
	
	@Field("idFactura")
	public Long idf;
	
	@Field("tipoNota")
	public String tipo;
	
	
	
	public NotaCredito() {
		
	}

	public NotaCredito(Long id, Date fecha,String responsable, double valor, String observaciones,Long idf,String tipo) {
		this.id = id;
		this.fecha = fecha;
		this.responsable = responsable;
		this.valor = valor;
		this.observaciones = observaciones;
		this.idf=idf;
		this.tipo=tipo;
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
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor =valor;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getIdf() {
		return idf;
	}

	public void setIdf(Long idf) {
		this.idf = idf;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	/*public float getTotal() {
		float total=0;
		for(NotaCredito nc: this.notaCredito) {
			total += nc.valor;
		}
		
		return 0;
	}*/
	
	
	
}
