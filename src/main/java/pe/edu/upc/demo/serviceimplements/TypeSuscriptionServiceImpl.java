package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.TypeSuscription;
import pe.edu.upc.demo.repositories.ITypeSuscriptionRepository;
import pe.edu.upc.demo.serviceinterface.ITypeSuscriptionService;

@Service
public class TypeSuscriptionServiceImpl implements ITypeSuscriptionService{

	@Autowired
	private ITypeSuscriptionRepository typesuscriptionRepository;
	
	
	@Override
	@Transactional
	public void Insert(TypeSuscription typesuscription) {
		typesuscriptionRepository.save(typesuscription);
	}

	@Override
	public List<TypeSuscription> list() {
		return typesuscriptionRepository.findAll();
	}

	@Override
	@Transactional
	public void Delete(int idTypeSuscription) {
		typesuscriptionRepository.deleteById(idTypeSuscription);
	}

	@Override
	@Transactional
	public void modificar(TypeSuscription typesuscription) {
		typesuscriptionRepository.save(typesuscription);
	}

	@Override
	public Optional<TypeSuscription> listarId(int idTypeSuscription) {
		return typesuscriptionRepository.findById(idTypeSuscription);
	}

	@Override
	public List<String[]> CantidadSuscripcionesXEmpresa() {
		return typesuscriptionRepository.CantidadSuscripcionesXEmpresa();
	}
	

	
}
