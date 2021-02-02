package com.t9.octavo.services;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.NotaCredito;
import com.t9.octavo.repos.NotaCreditoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class NotaCreditoService {

	@Autowired
	NotaCreditoRepository repo;

	public List<NotaCredito> getAll(){
		List<NotaCredito> notaCreditoList = repo.findAll();
		if(notaCreditoList.size() > 0) {
			return notaCreditoList;
		} else {
			return new ArrayList<NotaCredito>();
		}
	}
     		
	public NotaCredito findById(Long id) throws RecordNotFoundException{
		Optional<NotaCredito> notaCredito = repo.findById(id);
		if(notaCredito.isPresent()) {
			return notaCredito.get();
		} else {
			throw new RecordNotFoundException("No existe id de la nota de crédito");
		}
	}

	public List<NotaCredito> findByResponsableContaining(String responsable){
		List<NotaCredito> notaCreditoList = repo.findByResponsableContaining(responsable);
		if(notaCreditoList.size() > 0) {
			return notaCreditoList;
		} else {
			return new ArrayList<NotaCredito>();
		}
	}
	
	public List<NotaCredito> findByFecha(Date fecha){
		List<NotaCredito> notaCreditoList = repo.findAllByFecha(fecha);		
		if(notaCreditoList.size() > 0) {
			return notaCreditoList;
		} else {
			return new ArrayList<NotaCredito>();
		}
	}
	
	public NotaCredito createnotaCredito(NotaCredito notaCredito){
		return repo.save(notaCredito);
	}

	public NotaCredito updatenotaCredito(NotaCredito notaCredito) throws RecordNotFoundException {
		Optional<NotaCredito> notaCreditoTemp = repo.findById(notaCredito.getId());
	
		if(notaCreditoTemp.isPresent()){
			return repo.save(notaCredito);
		} else {
			throw new RecordNotFoundException("No existe id de la nota de crédito");
		}
	}

	public void deletenotaCreditoById(Long id) throws RecordNotFoundException{
		Optional<NotaCredito> notaCredito = repo.findById(id);
		if(notaCredito.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("No existe id de la nota de crédito");
		}
	}		
}
