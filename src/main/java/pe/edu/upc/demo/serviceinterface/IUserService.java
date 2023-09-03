package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Users;

public interface IUserService {
	public void insertar(Users u);
	public void Delete(Long idUser);
	List<Users> listar();
	Optional<Users> listarId(Long idUser);
}
