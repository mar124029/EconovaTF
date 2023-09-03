package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Report;
import pe.edu.upc.demo.repositories.IReportRepository;
import pe.edu.upc.demo.serviceinterface.IReportService;

@Service
public class ReportServiceImpl implements IReportService{

	@Autowired
	private IReportRepository reportRepository;
	
	@Override
	public void Insert(Report report) {
		reportRepository.save(report);
	}

	@Override
	public List<Report> list() {
		return reportRepository.findAll();
	}

	@Override
	public void Delete(int idReport) {
		reportRepository.deleteById(idReport);
	}

	@Override
	public void modificar(Report report) {
		reportRepository.save(report);
	}

	@Override
	public Optional<Report> listarId(int idReport) {
		return reportRepository.findById(idReport);
	}
	
}
