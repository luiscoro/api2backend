package logica;

import com.t9.octavo.models.Factura;
import com.t9.octavo.models.NotaCredito;
import com.t9.octavo.repos.FacturaRepository;
import com.t9.octavo.repos.NotaCreditoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.Set;


@Service
public class ControlNotaCredito {

	@Autowired
	NotaCreditoRepository repo;
	
	
	@Autowired
	 FacturaRepository repofac;

	private Set<NotaCredito> notaCredito;
	
	NotaCredito nc;
	
	public boolean findById(Long id){
		Optional<Factura> factura = repofac.findById(id);
		if(factura.isPresent()) {
			return true;
		} else {
			return false;
		}
	} 
	
	public boolean limiteNotaCredito(double totalFactura) {//valor de la factura
	//double valor = nc.getValor();//valor de la nota de credito
	double cont =0;
	cont = nc.getTotal();
	
	if( cont >totalFactura) {
		return false;
	}else {return true;//el valor de la nota de credito es menor al de la factura
	}
	
	}
}
