package com.t9.octavo.controllers;

import com.t9.octavo.RecordNotFoundException;

import com.t9.octavo.models.NotaCredito;
import com.t9.octavo.services.FacturaService;
import com.t9.octavo.services.NotaCreditoService;
import com.t9.octavo.services.SequenceGeneratorService;
import com.t9.octavo.services.TipoNotaCreditoService;

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
public class NotaCreditoController {
	@Autowired
	NotaCreditoService service;
	
	@Autowired
	SequenceGeneratorService seg;
	
	@Autowired
	TipoNotaCreditoService ts;
	
	@Autowired
	FacturaService servicef;
	
	
	@GetMapping("/notaCredito")
	public ResponseEntity<List<NotaCredito>> getAll() {
		List<NotaCredito> list = service.getAll();
		return new ResponseEntity<List<NotaCredito>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/notaCredito/{id}")
	public ResponseEntity<NotaCredito> getnotaCreditoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		NotaCredito entity = service.findById(id);
		return new ResponseEntity<NotaCredito>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/notaCredito/findbyresponsable/{responsable}")
	public ResponseEntity<List<NotaCredito>> getByResponsable(@PathVariable("responsable") String responsable){
		List<NotaCredito> list = service.findByResponsableContaining(responsable);
		return new ResponseEntity<List<NotaCredito>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@GetMapping("/notaCredito/findbyfecha/{fecha}")
	public ResponseEntity<List<NotaCredito>> getByFecha(@PathVariable("fecha") String fecha) throws ParseException{
		List<NotaCredito> list = service.findByFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
		return new ResponseEntity<List<NotaCredito>>(list, new HttpHeaders(), HttpStatus.OK);
	}				

	@PostMapping("/notaCredito")
	public ResponseEntity<NotaCredito> createnotaCredito(@RequestBody NotaCredito notaCredito){
	
		/*String id="1";
		if(cnc.findById(id)){
			
			if(cnc.limiteNotaCredito(factura.getTotalVenta())) {
				//false mayor
				//true menor o igual*/
		
		if (servicef.findById1(notaCredito.getIdf()) && ts.findByDetalle(notaCredito.getTipo())) {
				notaCredito.setId(seg.getSequenceNumbernC(NotaCredito.SEQUENCE_NAME));//generamos el id increm
				service.createnotaCredito(notaCredito);//creamos la nota credito
				return new ResponseEntity<NotaCredito>(notaCredito, new HttpHeaders(), HttpStatus.OK);
			}else {
				return new ResponseEntity<NotaCredito>(notaCredito, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}
			
		/*}else {
			return new ResponseEntity<NotaCredito>(notaCredito, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}	
	}	*/
}
	

	@PutMapping("/notaCredito")
	public ResponseEntity<NotaCredito> updatenotaCredito(@RequestBody NotaCredito notaCredito) throws RecordNotFoundException{
		
		if(ts.findByDetalle(notaCredito.getTipo())) {
		service.updatenotaCredito(notaCredito);
		return new ResponseEntity<NotaCredito>(notaCredito, new HttpHeaders(), HttpStatus.OK);
		}else {
			return new ResponseEntity<NotaCredito>(notaCredito, new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/notaCredito/{id}")
	public HttpStatus deletenotaCreditoById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deletenotaCreditoById(id);
		return HttpStatus.OK;
	}
}				
