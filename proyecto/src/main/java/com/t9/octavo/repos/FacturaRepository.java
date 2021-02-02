package com.t9.octavo.repos;

import java.util.Optional;

import com.t9.octavo.models.Factura;

public interface FacturaRepository {

	Optional<Factura> findById(Long id);

	
	
}
