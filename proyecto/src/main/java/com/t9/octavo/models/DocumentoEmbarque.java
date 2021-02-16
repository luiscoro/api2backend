package com.t9.octavo.models;

import java.util.Date;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import com.fasterxml.jackson.annotation.JsonFormat;

@Document (collection = "documentoEmbarque")
public class DocumentoEmbarque {
	
	@Transient
    public static final String SEQUENCE_NAME = "user_sequence";
	
	@Id
	@Field("_id")
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Field("fechaDocumentoEmbarque")
	private Date fecha = new Date();
	
	@Field("sectorEmbarque")
	private String sector;
		
	
	@Size(max=200)
    @Field("observacionesDocumentoEmbarque")
	private String observaciones;
	
	@Field("idGuia")
	public Long idg;
	
	public DocumentoEmbarque() {

	}

	public DocumentoEmbarque(Long id, Date fecha, String sector, String observaciones, Long idg) {

		this.id = id;
		this.fecha = fecha;
		this.sector = sector;
		this.observaciones = observaciones;
		this.idg = idg;
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
	
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
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
	
	public Long getIdg() {
		return idg;
	}

	public void setIdg(Long idg) {
		this.idg = idg;
	}
	
}
