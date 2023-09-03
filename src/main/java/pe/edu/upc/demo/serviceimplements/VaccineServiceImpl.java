package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Vaccine;
import pe.edu.upc.demo.repositories.IVaccineRepository;
import pe.edu.upc.demo.serviceinterface.IVaccineService;

@Service
public class VaccineServiceImpl implements IVaccineService{

	@Autowired
	private IVaccineRepository vaccineRepository;
	
	@Override
	public void Insert(Vaccine vaccine) {
		vaccineRepository.save(vaccine);
	}

	@Override
	public List<Vaccine> list() {
		return vaccineRepository.findAll();
	}

	@Override
	public void Delete(int idVaccine) {
		vaccineRepository.deleteById(idVaccine);
	}
	
	@Override
	public Optional<Vaccine> listId(int idVaccine) {
		return vaccineRepository.findById(idVaccine);
	}

	@Override
	public void update(Vaccine vaccine) {
		vaccineRepository.save(vaccine);
		
	}
	
}
