package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Driver;

public interface IDriverService {
	public void Insert(Driver driver);
	public List<Driver> list();
	public void Delete(int idDriver);
	public void modificar(Driver driver);
	Optional<Driver> listarId(int idDriver);
}
