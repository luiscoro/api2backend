package com.t9.octavo.controllers;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.GuiaRemisionDespacho;
import com.t9.octavo.services.ChoferDespachoService;
import com.t9.octavo.services.GuiaRemisionDespachoService;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.text.ParseException;
import java.text.SimpleDateFormat;	

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GuiaRemisionDespachoController {
	@Autowired
	GuiaRemisionDespachoService service;
	
	@Autowired
	SequenceGeneratorService seg;
	
	@Autowired
	ChoferDespachoService cd;
	
	@GetMapping("/guiaRemisionDespacho")
	public ResponseEntity<List<GuiaRemisionDespacho>> getAll() {
		List<GuiaRemisionDespacho> list = service.getAll();
		return new ResponseEntity<List<GuiaRemisionDespacho>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/guiaRemisionDespacho/{id}")
	public ResponseEntity<GuiaRemisionDespacho> getguiaRemisionDespachoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		GuiaRemisionDespacho entity = service.findById(id);
		return new ResponseEntity<GuiaRemisionDespacho>(entity, new HttpHeaders(), HttpStatus.OK);
	}


	@GetMapping("/guiaRemisionDespacho/findbyfecha/{fecha}")
	public ResponseEntity<List<GuiaRemisionDespacho>> getByFecha(@PathVariable("fecha") String fecha) throws ParseException{
		List<GuiaRemisionDespacho> list = service.findByFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		return new ResponseEntity<List<GuiaRemisionDespacho>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/guiaRemisionDespacho")
	public ResponseEntity<GuiaRemisionDespacho> createguiaRemisionDespacho(@RequestBody GuiaRemisionDespacho guiaRemisionDespacho){
		
		if (cd.findByNombre(guiaRemisionDespacho.getChofer())) {
		guiaRemisionDespacho.setId(seg.getSequenceNumbergR(GuiaRemisionDespacho.SEQUENCE_NAME));
		service.createguiaRemisionDespacho(guiaRemisionDespacho);
		return new ResponseEntity<GuiaRemisionDespacho>(guiaRemisionDespacho, new HttpHeaders(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<GuiaRemisionDespacho>(guiaRemisionDespacho, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/guiaRemisionDespacho")
	public ResponseEntity<GuiaRemisionDespacho> updateguiaRemisionDespacho(@RequestBody GuiaRemisionDespacho guiaRemisionDespacho) throws RecordNotFoundException{
		
		if (cd.findByNombre(guiaRemisionDespacho.getChofer())) {
		service.updateguiaRemisionDespacho(guiaRemisionDespacho);
		return new ResponseEntity<GuiaRemisionDespacho>(guiaRemisionDespacho, new HttpHeaders(), HttpStatus.OK);
		}else {
			return new ResponseEntity<GuiaRemisionDespacho>(guiaRemisionDespacho, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/guiaRemisionDespacho/{id}")
	public HttpStatus deleteguiaRemisionDespachoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteguiaRemisionDespachoById(id);
		return HttpStatus.OK;
	}
}				
