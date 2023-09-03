package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.ListVaccination;

public interface IListVaccinationService {
	public void Insert(ListVaccination Listvaccination);
	List<ListVaccination> list();
	public void Delete(int idListvaccination);
	public void modificar(ListVaccination Listvaccination);
	Optional<ListVaccination> listarId(int idListvaccination);
}
