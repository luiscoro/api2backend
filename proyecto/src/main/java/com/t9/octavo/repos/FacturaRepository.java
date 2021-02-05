package com.t9.octavo.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.Factura;

@Repository
public interface FacturaRepository extends MongoRepository<Factura,String>{

	Optional<Factura> findById(String IdFactura);

	
	
}
