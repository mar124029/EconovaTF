package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Report")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReport;
	@Column(name = "descriptionService", nullable = false, length = 300)
	private String descriptionService;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateReport", nullable = false)
	private Date dateReport;
	
	@ManyToOne
	@JoinColumn(name = "idService")
	private Service service;
	
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int idReport, String descriptionService, Date dateReport, Service service) {
		super();
		this.idReport = idReport;
		this.descriptionService = descriptionService;
		this.dateReport = dateReport;
		this.service = service;
	}

	public int getIdReport() {
		return idReport;
	}


	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}


	public String getDescriptionService() {
		return descriptionService;
	}


	public void setDescriptionService(String descriptionService) {
		this.descriptionService = descriptionService;
	}


	public Date getDateReport() {
		return dateReport;
	}


	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
	
	
	
	
}
