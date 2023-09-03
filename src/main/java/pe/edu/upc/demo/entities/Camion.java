package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Camion")
public class Camion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCamion;
	@NotEmpty(message="Ingrese el modelo!")
	@Column(name = "modeloCamion",nullable = false,length = 50)
	private String modeloCamion;
	@NotEmpty(message="Ingrese el color!")
	@Column(name = "colorCamion",nullable = false,length = 20)
	private String colorCamion;
	@NotEmpty(message="Ingrese la placa!")
	@Size(min=6,max=6, message="La placa esta comprendida por 6 caracteres")
	@Column(name = "placaCamion",nullable = false,length = 20)
	private String placaCamion;
	
	@Min(1)
	@Max(4)
	@Column(name = "capacidadCamion",nullable = false)
	private int capacidadCamion;
	
	@ManyToOne
	@JoinColumn(name="idDriver")
	private Driver driver;

	public Camion() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Camion(int idCamion, @NotEmpty(message = "Ingrese el modelo!") String modeloCamion,
			@NotEmpty(message = "Ingrese el color!") String colorCamion,
			@NotEmpty(message = "Ingrese la placa!") @Size(min = 6, max = 6, message = "La placa esta comprendida por 6 caracteres") String placaCamion,
			@Min(1) @Max(4) int capacidadCamion, Driver driver) {
		super();
		this.idCamion = idCamion;
		this.modeloCamion = modeloCamion;
		this.colorCamion = colorCamion;
		this.placaCamion = placaCamion;
		this.capacidadCamion = capacidadCamion;
		this.driver = driver;
	}

	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	public String getModeloCamion() {
		return modeloCamion;
	}

	public void setModeloCamion(String modeloCamion) {
		this.modeloCamion = modeloCamion;
	}

	public String getColorCamion() {
		return colorCamion;
	}

	public void setColorCamion(String colorCamion) {
		this.colorCamion = colorCamion;
	}

	public String getPlacaCamion() {
		return placaCamion;
	}

	public void setPlacaCamion(String placaCamion) {
		this.placaCamion = placaCamion;
	}

	public int getCapacidadCamion() {
		return capacidadCamion;
	}

	public void setCapacidadCamion(int capacidadCamion) {
		this.capacidadCamion = capacidadCamion;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
	
	
	
}
