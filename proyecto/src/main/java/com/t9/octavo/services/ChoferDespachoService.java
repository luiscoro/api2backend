package com.t9.octavo.services;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.ChoferDespacho;
import com.t9.octavo.repos.ChoferDespachoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChoferDespachoService {

	@Autowired
	ChoferDespachoRepository repo;
	
	

	public List<ChoferDespacho> getAll(){
		List<ChoferDespacho> choferDespachoList = repo.findAll();
		if(choferDespachoList.size() > 0) {
			return choferDespachoList;
		} else {
			return new ArrayList<ChoferDespacho>();
		}
	}
     		
	public ChoferDespacho findById(Long id) throws RecordNotFoundException{
		Optional<ChoferDespacho> choferDespacho = repo.findById(id);
		if(choferDespacho.isPresent()) {
			return choferDespacho.get();
		} else {
			throw new RecordNotFoundException("No existe el id del chofer");
		}
	}

	public boolean findByNombre(String nombre){
		Optional<ChoferDespacho> choferDespacho = repo.findByNombre(nombre);
		if(choferDespacho.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean findByPlaca(String placa){
		Optional<ChoferDespacho> choferDespacho = repo.findByPlaca(placa);
		if(choferDespacho.isPresent()) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<ChoferDespacho> findByNombreContaining(String nombre){
		List<ChoferDespacho> choferDespachoList = repo.findByNombreContaining(nombre);
		if(choferDespachoList.size() > 0) {
			return choferDespachoList;
		} else {
			return new ArrayList<ChoferDespacho>();
		}
	}
	
	public ChoferDespacho createchoferDespacho(ChoferDespacho choferDespacho){
		return repo.save(choferDespacho);
	}

	public ChoferDespacho updatechoferDespacho(ChoferDespacho choferDespacho) throws RecordNotFoundException {
		Optional<ChoferDespacho> choferDespachoTemp = repo.findById(choferDespacho.getId());
	
		if(choferDespachoTemp.isPresent()){
			return repo.save(choferDespacho);
		} else {
			throw new RecordNotFoundException("No existe el id del chofer");
		}
	}

	public void deletechoferDespachoById(Long id) throws RecordNotFoundException{
		Optional<ChoferDespacho> choferDespacho = repo.findById(id);
		if(choferDespacho.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No existe el id del chofer");
		}
	}		
	

}
