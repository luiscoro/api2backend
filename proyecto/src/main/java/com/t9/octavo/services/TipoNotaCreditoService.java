package com.t9.octavo.services;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.TipoNotaCredito;
import com.t9.octavo.repos.TipoNotaCreditoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoNotaCreditoService {

	@Autowired
	TipoNotaCreditoRepository repo;

	
	public List<TipoNotaCredito> getAll(){
		List<TipoNotaCredito> tipoNotaCreditoList = repo.findAll();
		if(tipoNotaCreditoList.size() > 0) {
			return tipoNotaCreditoList;
		} else {
			return new ArrayList<TipoNotaCredito>();
		}
	}
     		
	public TipoNotaCredito findById(Long id) throws RecordNotFoundException{
		Optional<TipoNotaCredito> tipoNotaCredito = repo.findById(id);
		if(tipoNotaCredito.isPresent()) {
			return tipoNotaCredito.get();
		} else {
			throw new RecordNotFoundException("Dicho id de nota de crédito no existe");
		}
	}

	public List<TipoNotaCredito> findByDetalleContaining(String detalle){
		List<TipoNotaCredito> tipoNotaCreditoList = repo.findByDetalleContaining(detalle);
		if(tipoNotaCreditoList.size() > 0) {
			return tipoNotaCreditoList;
		} else {
			return new ArrayList<TipoNotaCredito>();
		}
	}
	
	public TipoNotaCredito createtipoNotaCredito(TipoNotaCredito tipoNotaCredito){
		
		return repo.save(tipoNotaCredito);
	}

	public TipoNotaCredito updatetipoNotaCredito(TipoNotaCredito tipoNotaCredito) throws RecordNotFoundException {
		Optional<TipoNotaCredito> tipoNotaCreditoTemp = repo.findById(tipoNotaCredito.getId());
	
		if(tipoNotaCreditoTemp.isPresent()){
			return repo.save(tipoNotaCredito);
		} else {
			throw new RecordNotFoundException("Dicho id de nota de crédito no existe");
		}
	}

	public void deletetipoNotaCreditoById(Long id) throws RecordNotFoundException{
		Optional<TipoNotaCredito> tipoNotaCredito = repo.findById(id);
		if(tipoNotaCredito.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Dicho id de nota de crédito no existe");
		}
	}
	
	/*public void acumuladoNotaCredito() throws RecordNotFoundException{
		Optional<TipoNotaCredito> tipoNotaCreditoOptio
	}*/
	

}
