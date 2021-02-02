																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Thu Jan 21 00:06:01 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.t9.octavo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone;
import javax.annotation.PostConstruct;					

@SpringBootApplication
public class OctavoApplication {
	public static void main(String[] args) {
		SpringApplication.run(OctavoApplication.class, args);
		System.out.println("Active resources for choferDespacho entity");
		System.out.println("GET");
		System.out.println("/api/v1/choferDespacho");
		System.out.println("/api/v1/choferDespacho/{id}");
		System.out.println("/api/v1/choferDespacho/findbynombre/{nombre}");
		System.out.println("POST");
		System.out.println("/api/v1/choferDespacho");
		System.out.println("PUT");
		System.out.println("/api/v1/choferDespacho");
		System.out.println("DELETE");
		System.out.println("/api/v1/choferDespacho/{id}");
		System.out.println("Active resources for documentoEmbarque entity");
		System.out.println("GET");
		System.out.println("/api/v1/documentoEmbarque");
		System.out.println("/api/v1/documentoEmbarque/{id}");
		System.out.println("/api/v1/documentoEmbarque/findbyfecha/{fecha}");
		System.out.println("POST");
		System.out.println("/api/v1/documentoEmbarque");
		System.out.println("PUT");
		System.out.println("/api/v1/documentoEmbarque");
		System.out.println("DELETE");
		System.out.println("/api/v1/documentoEmbarque/{id}");
		System.out.println("Active resources for guiaRemisionDespacho entity");
		System.out.println("GET");
		System.out.println("/api/v1/guiaRemisionDespacho");
		System.out.println("/api/v1/guiaRemisionDespacho/{id}");
		System.out.println("/api/v1/guiaRemisionDespacho/findbyfecha/{fecha}");
		System.out.println("POST");
		System.out.println("/api/v1/guiaRemisionDespacho");
		System.out.println("PUT");
		System.out.println("/api/v1/guiaRemisionDespacho");
		System.out.println("DELETE");
		System.out.println("/api/v1/guiaRemisionDespacho/{id}");
		System.out.println("Active resources for notaCredito entity");
		System.out.println("GET");
		System.out.println("/api/v1/notaCredito");
		System.out.println("/api/v1/notaCredito/{id}");
		System.out.println("/api/v1/notaCredito/findbyresponsable/{responsable}");
		System.out.println("/api/v1/notaCredito/findbyfecha/{fecha}");
		System.out.println("POST");
		System.out.println("/api/v1/notaCredito");
		System.out.println("PUT");
		System.out.println("/api/v1/notaCredito");
		System.out.println("DELETE");
		System.out.println("/api/v1/notaCredito/{id}");
		System.out.println("Active resources for tipoNotaCredito entity");
		System.out.println("GET");
		System.out.println("/api/v1/tipoNotaCredito");
		System.out.println("/api/v1/tipoNotaCredito/{id}");
		System.out.println("/api/v1/tipoNotaCredito/findbydetalle/{detalle}");
		System.out.println("POST");
		System.out.println("/api/v1/tipoNotaCredito");
		System.out.println("PUT");
		System.out.println("/api/v1/tipoNotaCredito");
		System.out.println("DELETE");
		System.out.println("/api/v1/tipoNotaCredito/{id}");
	}
	
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}						
}
