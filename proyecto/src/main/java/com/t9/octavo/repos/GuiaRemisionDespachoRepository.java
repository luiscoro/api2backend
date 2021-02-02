
package com.t9.octavo.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.GuiaRemisionDespacho;

import java.util.Optional;

@Repository
public interface GuiaRemisionDespachoRepository extends MongoRepository<GuiaRemisionDespacho, Long> {

	Optional <GuiaRemisionDespacho> findById(Long id);
	
	void deleteById(Long id);
	
	List<GuiaRemisionDespacho> findAllByFecha(Date fecha);	
	
}
