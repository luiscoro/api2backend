
package com.t9.octavo.repos;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.DocumentoEmbarque;

import java.util.Optional;

@Repository
public interface DocumentoEmbarqueRepository extends MongoRepository<DocumentoEmbarque, Long> {

	Optional <DocumentoEmbarque> findById(Long id);
	
	void deleteById(Long id);
	
	List<DocumentoEmbarque> findAllByFecha(Date fecha);	
	
}
