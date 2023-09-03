package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Invoice;

public interface IinvoiceService {
	public void Insert(Invoice invoice);
	public List<Invoice> list();
	public void Delete(int idInvoice);
	public void modificar(Invoice invoice);
	Optional<Invoice> listarId(int idInvoice);
}
