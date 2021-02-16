package com.t9.octavo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.Factura;
import com.t9.octavo.repos.FacturaRepository;


@Service
public class FacturaService {
	
	@Autowired
	FacturaRepository repo;
	

	public List<Factura> getAll(){
		List<Factura> facturaList = repo.findAll();
		if(facturaList.size() > 0) {
			return facturaList;
		} else {
			return new ArrayList<Factura>();
		}
	}
     		
	public Factura findById(Long id) throws RecordNotFoundException{
		Optional<Factura> factura = repo.findById(id);
		if(factura.isPresent()) {
			return factura.get();
		} else {
			throw new RecordNotFoundException("No existe id");
		}
	}
	
	public boolean findById1(Long id){
		Optional<Factura> fac = repo.findById(id);
		if(fac.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
}
