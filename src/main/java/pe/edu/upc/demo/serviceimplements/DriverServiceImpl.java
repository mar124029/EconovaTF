package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Driver;
import pe.edu.upc.demo.repositories.IDriverRepository;
import pe.edu.upc.demo.serviceinterface.IDriverService;

@Service
public class DriverServiceImpl implements IDriverService{

	@Autowired
	private IDriverRepository driverRepository;
	
	@Override
	public void Insert(Driver driver) {
		driverRepository.save(driver);	
	}
	
	@Override
	public List<Driver> list() {
		return driverRepository.findAll();
	}

	@Override
	public void Delete(int idDriver) {
		driverRepository.deleteById(idDriver);
	}

	@Override
	public void modificar(Driver driver) {
		driverRepository.save(driver);
	}

	@Override
	public Optional<Driver> listarId(int idDriver) {
		return driverRepository.findById(idDriver);
	}
	
}
