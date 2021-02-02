package com.t9.octavo.services;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.GuiaRemisionDespacho;
import com.t9.octavo.repos.GuiaRemisionDespachoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class GuiaRemisionDespachoService {

	@Autowired
	GuiaRemisionDespachoRepository repo;

	public List<GuiaRemisionDespacho> getAll(){
		List<GuiaRemisionDespacho> guiaRemisionDespachoList = repo.findAll();
		if(guiaRemisionDespachoList.size() > 0) {
			return guiaRemisionDespachoList;
		} else {
			return new ArrayList<GuiaRemisionDespacho>();
		}
	}
     		
	public GuiaRemisionDespacho findById(Long id) throws RecordNotFoundException{
		Optional<GuiaRemisionDespacho> guiaRemisionDespacho = repo.findById(id);
		if(guiaRemisionDespacho.isPresent()) {
			return guiaRemisionDespacho.get();
		} else {
			throw new RecordNotFoundException("No existe id de guia de remisión");
		}
	}

	public List<GuiaRemisionDespacho> findByFecha(Date fecha){
		List<GuiaRemisionDespacho> guiaRemisionDespachoList = repo.findAllByFecha(fecha);		
		if(guiaRemisionDespachoList.size() > 0) {
			return guiaRemisionDespachoList;
		} else {
			return new ArrayList<GuiaRemisionDespacho>();
		}
	}
	
	public GuiaRemisionDespacho createguiaRemisionDespacho(GuiaRemisionDespacho guiaRemisionDespacho){
		return repo.save(guiaRemisionDespacho);
	}

	public GuiaRemisionDespacho updateguiaRemisionDespacho(GuiaRemisionDespacho guiaRemisionDespacho) throws RecordNotFoundException {
		Optional<GuiaRemisionDespacho> guiaRemisionDespachoTemp = repo.findById(guiaRemisionDespacho.getId());
	
		if(guiaRemisionDespachoTemp.isPresent()){
			return repo.save(guiaRemisionDespacho);
		} else {
			throw new RecordNotFoundException("No existe id de guia de remisión");
		}
	}

	public void deleteguiaRemisionDespachoById(Long id) throws RecordNotFoundException{
		Optional<GuiaRemisionDespacho> guiaRemisionDespacho = repo.findById(id);
		if(guiaRemisionDespacho.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No existe id de guia de remisión");
		}
	}		

}
