package com.t9.octavo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.Factura;

import com.t9.octavo.services.FacturaService;


@RestController
@RequestMapping("/api")
public class FacturaController {
	@Autowired
	FacturaService service;
	
	@GetMapping("/factura")
	public ResponseEntity<List<Factura>> getAll() {
		List<Factura> list = service.getAll();
		return new ResponseEntity<List<Factura>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/factura/{id}")
	public ResponseEntity<Factura> getfacturaById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Factura entity = service.findById(id);
		return new ResponseEntity<Factura>(entity, new HttpHeaders(), HttpStatus.OK);
	}
}
