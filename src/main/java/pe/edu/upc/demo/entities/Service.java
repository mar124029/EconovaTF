package pe.edu.upc.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	@NotEmpty(message="Ingrese el residuo!")
	@Column(name = "typewaste", nullable = false, length = 60)
	private String typewaste;
	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha es en pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateService", nullable = false)
	private Date dateService;
	@Min(1000)
	@Max(6000)
	@Column(name = "quantityWaste", nullable = false, length = 60)
	private int quantityWaste;
	@Min(1)
	@Max(4)
	@Column(name = "quantityDriver", nullable = false, length = 60)
	private int quantityDriver;
	@ManyToOne
	@JoinColumn(name = "idCompany")
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name = "idCamion")
	private Camion camion;
	public Service() {
		super();
		//TODO Auto-generated constructor stub
	}
	public Service(int idService, @NotEmpty(message = "Ingrese el residuo!") String typewaste,
			@NotNull(message = "La fecha es obligatoria") @Past(message = "La fecha es en pasado") Date dateService,
			@Min(1000) @Max(6000) int quantityWaste, @Min(1) @Max(4) int quantityDriver, Empresa empresa,
			Camion camion) {
		super();
		this.idService = idService;
		this.typewaste = typewaste;
		this.dateService = dateService;
		this.quantityWaste = quantityWaste;
		this.quantityDriver = quantityDriver;
		this.empresa = empresa;
		this.camion = camion;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public String getTypewaste() {
		return typewaste;
	}
	public void setTypewaste(String typewaste) {
		this.typewaste = typewaste;
	}
	public Date getDateService() {
		return dateService;
	}
	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}
	public int getQuantityWaste() {
		return quantityWaste;
	}
	public void setQuantityWaste(int quantityWaste) {
		this.quantityWaste = quantityWaste;
	}
	public int getQuantityDriver() {
		return quantityDriver;
	}
	public void setQuantityDriver(int quantityDriver) {
		this.quantityDriver = quantityDriver;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	
	
	
	
	
	
}
