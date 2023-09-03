package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Camion;
import pe.edu.upc.demo.repositories.ICamionRepository;
import pe.edu.upc.demo.serviceinterface.ICamionService;

@Service
public class CamionServiceImpl implements ICamionService{

	@Autowired	
	private ICamionRepository camionRepository;
	
	@Override
	public void Insert(Camion camion) {
		camionRepository.save(camion);
	}

	@Override
	public List<Camion> list() {
		return camionRepository.findAll();
	}

	@Override
	public void delete(int idCamion) {
		camionRepository.deleteById(idCamion);
	}

	@Override
	public void modificar(Camion camion) {
		camionRepository.save(camion);
	}

	@Override
	public Optional<Camion> listarId(int idCamion) {
		return camionRepository.findById(idCamion);
	}


}
