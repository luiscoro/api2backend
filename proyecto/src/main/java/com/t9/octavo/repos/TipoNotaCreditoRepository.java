
package com.t9.octavo.repos;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.t9.octavo.models.TipoNotaCredito;

import java.util.Optional;

@Repository
public interface TipoNotaCreditoRepository extends MongoRepository<TipoNotaCredito, Long> {

	Optional <TipoNotaCredito> findById(Long id);
	
	Optional <TipoNotaCredito> findByDetalle(String detalle);
	
	void deleteById(Long id);
	
	List<TipoNotaCredito> findByDetalleContaining(String detalle);
	
}
