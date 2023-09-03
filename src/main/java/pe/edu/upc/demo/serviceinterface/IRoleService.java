package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Role;

public interface IRoleService {
	public void insertar(Role r);
	List<Role> listar();
	public void modificar(Role role);
	public void Delete(Long idRole);
	Optional<Role> listarId(Long idRole);
}
