package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Vaccine;

public interface IVaccineService {
	public void Insert(Vaccine vaccine);
	public List<Vaccine> list();
	public void Delete(int idVaccine);
	Optional<Vaccine>listId(int idVaccine);
	public void update(Vaccine vaccine);
}
