package com.t9.octavo.repos;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.ChoferDespacho;

import java.util.Optional;

@Repository
public interface ChoferDespachoRepository extends MongoRepository<ChoferDespacho, Long> {

	Optional <ChoferDespacho> findById(Long id);
	
	Optional <ChoferDespacho> findByNombre(String nombre);
	
	void deleteById(Long id);
	
	List<ChoferDespacho> findByNombreContaining(String nombre);
	
}
