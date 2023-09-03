package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.ListVaccination;
import pe.edu.upc.demo.repositories.IListVaccinationRepository;
import pe.edu.upc.demo.serviceinterface.IListVaccinationService;

@Service
public class ListVaccinationServiceImpl implements IListVaccinationService{

	@Autowired
	private IListVaccinationRepository listvaccinationRepository;
	
	
	@Override
	public void Insert(ListVaccination Listvaccination) {
		listvaccinationRepository.save(Listvaccination);
	}

	@Override
	public List<ListVaccination> list() {
		return listvaccinationRepository.findAll();
	}

	@Override
	public void Delete(int idListvaccination) {
		listvaccinationRepository.deleteById(idListvaccination);
	}

	@Override
	public void modificar(ListVaccination Listvaccination) {
		listvaccinationRepository.save(Listvaccination);
	}

	@Override
	public Optional<ListVaccination> listarId(int idListvaccination) {
		return listvaccinationRepository.findById(idListvaccination);
	}
	
}
