																/*
 -------------------------------------------------------------------
|
| CRUDyLeaf	- A Domain Specific Language for generating Spring Boot 
|			REST resources from entity CRUD operations.
| Author: Omar S. Gómez (2020)
| File Date: Thu Jan 21 00:06:01 ECT 2021
| 
 -------------------------------------------------------------------
																*/
package com.t9.octavo.services;

import com.t9.octavo.RecordNotFoundException;
import com.t9.octavo.models.DocumentoEmbarque;
import com.t9.octavo.repos.DocumentoEmbarqueRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class DocumentoEmbarqueService {

	@Autowired
	DocumentoEmbarqueRepository repo;

	public List<DocumentoEmbarque> getAll(){
		List<DocumentoEmbarque> documentoEmbarqueList = repo.findAll();
		if(documentoEmbarqueList.size() > 0) {
			return documentoEmbarqueList;
		} else {
			return new ArrayList<DocumentoEmbarque>();
		}
	}
     		
	public DocumentoEmbarque findById(Long id) throws RecordNotFoundException{
		Optional<DocumentoEmbarque> documentoEmbarque = repo.findById(id);
		if(documentoEmbarque.isPresent()) {
			return documentoEmbarque.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public List<DocumentoEmbarque> findByFecha(Date fecha){
		List<DocumentoEmbarque> documentoEmbarqueList = repo.findAllByFecha(fecha);		
		if(documentoEmbarqueList.size() > 0) {
			return documentoEmbarqueList;
		} else {
			return new ArrayList<DocumentoEmbarque>();
		}
	}
	
	public DocumentoEmbarque createdocumentoEmbarque(DocumentoEmbarque documentoEmbarque){
		return repo.save(documentoEmbarque);
	}

	public DocumentoEmbarque updatedocumentoEmbarque(DocumentoEmbarque documentoEmbarque) throws RecordNotFoundException {
		Optional<DocumentoEmbarque> documentoEmbarqueTemp = repo.findById(documentoEmbarque.getId());
	
		if(documentoEmbarqueTemp.isPresent()){
			return repo.save(documentoEmbarque);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}

	public void deletedocumentoEmbarqueById(Long id) throws RecordNotFoundException{
		Optional<DocumentoEmbarque> documentoEmbarque = repo.findById(id);
		if(documentoEmbarque.isPresent()) {
		repo.deleteById(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}		

}
