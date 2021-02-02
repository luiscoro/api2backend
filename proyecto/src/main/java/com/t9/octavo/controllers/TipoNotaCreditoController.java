package com.t9.octavo.controllers;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.TipoNotaCredito;
import com.t9.octavo.services.SequenceGeneratorService;
import com.t9.octavo.services.TipoNotaCreditoService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.beans.beancontext.BeanContextServices;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;	
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
@RestController
@RequestMapping("/api/v1")
public class TipoNotaCreditoController {
	@Autowired
	TipoNotaCreditoService service;
	
	@Autowired
	SequenceGeneratorService seg;
	
	@GetMapping("/tipoNotaCredito")
	public ResponseEntity<List<TipoNotaCredito>> getAll() {
		List<TipoNotaCredito> list = service.getAll();
		return new ResponseEntity<List<TipoNotaCredito>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/tipoNotaCredito/{id}")
	public ResponseEntity<TipoNotaCredito> gettipoNotaCreditoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		TipoNotaCredito entity = service.findById(id);
		return new ResponseEntity<TipoNotaCredito>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/tipoNotaCredito/findbydetalle/{detalle}")
	public ResponseEntity<List<TipoNotaCredito>> getByDetalle(@PathVariable("detalle") String detalle){
		List<TipoNotaCredito> list = service.findByDetalleContaining(detalle);
		return new ResponseEntity<List<TipoNotaCredito>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/tipoNotaCredito")
	public ResponseEntity<TipoNotaCredito> createtipoNotaCredito(@RequestBody TipoNotaCredito tipoNotaCredito){
		
		tipoNotaCredito.setId(seg.getSequenceNumber(TipoNotaCredito.SEQUENCE_NAME));
		service.createtipoNotaCredito(tipoNotaCredito);
		return new ResponseEntity<TipoNotaCredito>(tipoNotaCredito, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/tipoNotaCredito")
	public ResponseEntity<TipoNotaCredito> updatetipoNotaCredito(@RequestBody TipoNotaCredito tipoNotaCredito) throws RecordNotFoundException{
		service.updatetipoNotaCredito(tipoNotaCredito);
		return new ResponseEntity<TipoNotaCredito>(tipoNotaCredito, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/tipoNotaCredito/{id}")
	public HttpStatus deletetipoNotaCreditoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletetipoNotaCreditoById(id);
		return HttpStatus.OK;
	}
}				
