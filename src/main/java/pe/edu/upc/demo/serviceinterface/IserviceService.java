package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Service;

public interface IserviceService {
	public void Insert(Service service);
	public List<Service> list();
	public void Delete(int idService);
	public void modificar(Service service);
	Optional<Service> listarId(int idService);
	public List<String[]> tipodesechocantidad();
}
