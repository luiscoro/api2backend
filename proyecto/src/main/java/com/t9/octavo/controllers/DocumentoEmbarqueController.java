package com.t9.octavo.controllers;

import com.t9.octavo.RecordNotFoundException;
//MODELO
import com.t9.octavo.models.DocumentoEmbarque;
//SERVICIO
import com.t9.octavo.services.DocumentoEmbarqueService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;	
@RestController
@RequestMapping("/api/v1")
public class DocumentoEmbarqueController {
	@Autowired
	DocumentoEmbarqueService service;
	
	@Autowired
	SequenceGeneratorService seg;
	
	@GetMapping("/documentoEmbarque")
	public ResponseEntity<List<DocumentoEmbarque>> getAll() {
		List<DocumentoEmbarque> list = service.getAll();
		return new ResponseEntity<List<DocumentoEmbarque>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/documentoEmbarque/{id}")
	public ResponseEntity<DocumentoEmbarque> getdocumentoEmbarqueById(@PathVariable("id") Long id) throws RecordNotFoundException {
		DocumentoEmbarque entity = service.findById(id);
		return new ResponseEntity<DocumentoEmbarque>(entity, new HttpHeaders(), HttpStatus.OK);
	}


	@GetMapping("/documentoEmbarque/findbyfecha/{fecha}")
	public ResponseEntity<List<DocumentoEmbarque>> getByFecha(@PathVariable("fecha") String fecha) throws ParseException{
		List<DocumentoEmbarque> list = service.findByFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		return new ResponseEntity<List<DocumentoEmbarque>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/documentoEmbarque")
	public ResponseEntity<DocumentoEmbarque> createdocumentoEmbarque(@RequestBody DocumentoEmbarque documentoEmbarque){
		documentoEmbarque.setId(seg.getSequenceNumber(DocumentoEmbarque.SEQUENCE_NAME));
		service.createdocumentoEmbarque(documentoEmbarque);
		return new ResponseEntity<DocumentoEmbarque>(documentoEmbarque, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/documentoEmbarque")
	public ResponseEntity<DocumentoEmbarque> updatedocumentoEmbarque(@RequestBody DocumentoEmbarque documentoEmbarque) throws RecordNotFoundException{
		service.updatedocumentoEmbarque(documentoEmbarque);
		return new ResponseEntity<DocumentoEmbarque>(documentoEmbarque, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/documentoEmbarque/{id}")
	public HttpStatus deletedocumentoEmbarqueById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletedocumentoEmbarqueById(id);
		return HttpStatus.OK;
	}
}				
