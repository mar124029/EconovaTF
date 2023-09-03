package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Report;

public interface IReportService {
	public void Insert(Report report);
	public List<Report> list();
	public void Delete(int idReport);
	public void modificar(Report report);
	Optional<Report> listarId(int idReport);
}
