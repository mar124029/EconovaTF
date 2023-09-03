package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Camion;

public interface ICamionService {
	public void Insert(Camion camion);
	public List<Camion> list();
	public void delete(int idCamion);
	public void modificar(Camion camion);
	Optional<Camion> listarId(int idCamion);
}
