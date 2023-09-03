package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.TypeSuscription;

public interface ITypeSuscriptionService {
	public void Insert(TypeSuscription typesuscription);
	public List<TypeSuscription> list();
	public void Delete(int idTypeSuscription);
	public void modificar(TypeSuscription typesuscription);
	Optional<TypeSuscription> listarId(int idTypeSuscription);
	public List<String[]> CantidadSuscripcionesXEmpresa();
}
