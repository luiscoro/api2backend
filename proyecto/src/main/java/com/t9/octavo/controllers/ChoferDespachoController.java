package com.t9.octavo.controllers;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.ChoferDespacho;
import com.t9.octavo.models.TipoNotaCredito;
import com.t9.octavo.services.ChoferDespachoService;
import com.t9.octavo.services.SequenceGeneratorService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ChoferDespachoController {
	@Autowired
	ChoferDespachoService service;
	
	@Autowired
	SequenceGeneratorService seg;
	
	@GetMapping("/choferDespacho")
	public ResponseEntity<List<ChoferDespacho>> getAll() {
		List<ChoferDespacho> list = service.getAll();
		return new ResponseEntity<List<ChoferDespacho>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/choferDespacho/{id}")
	public ResponseEntity<ChoferDespacho> getchoferDespachoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		ChoferDespacho entity = service.findById(id);
		return new ResponseEntity<ChoferDespacho>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/choferDespacho/findbynombre/{nombre}")
	public ResponseEntity<List<ChoferDespacho>> getByNombre(@PathVariable("nombre") String nombre){
		List<ChoferDespacho> list = service.findByNombreContaining(nombre);
		return new ResponseEntity<List<ChoferDespacho>>(list, new HttpHeaders(), HttpStatus.OK);
	}				


	@PostMapping("/choferDespacho")
	public ResponseEntity<ChoferDespacho> createchoferDespacho(@RequestBody ChoferDespacho choferDespacho){
		choferDespacho.setId(seg.getSequenceNumber(ChoferDespacho.SEQUENCE_NAME));
		service.createchoferDespacho(choferDespacho);
		return new ResponseEntity<ChoferDespacho>(choferDespacho, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/choferDespacho")
	public ResponseEntity<ChoferDespacho> updatechoferDespacho(@RequestBody ChoferDespacho choferDespacho) throws RecordNotFoundException{
		service.updatechoferDespacho(choferDespacho);
		return new ResponseEntity<ChoferDespacho>(choferDespacho, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/choferDespacho/{id}")
	public HttpStatus deletechoferDespachoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletechoferDespachoById(id);
		return HttpStatus.OK;
	}
}				
