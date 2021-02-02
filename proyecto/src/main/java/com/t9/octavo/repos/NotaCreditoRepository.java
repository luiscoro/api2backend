
package com.t9.octavo.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.NotaCredito;

import java.util.Optional;

@Repository
public interface NotaCreditoRepository extends MongoRepository<NotaCredito, Long> {

	Optional <NotaCredito> findById(Long id);
	
	void deleteById(Long id);
	
	List<NotaCredito> findByResponsableContaining(String responsable);
	
	List<NotaCredito> findAllByFecha(Date fecha);	
	
}
