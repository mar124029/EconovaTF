package pe.edu.upc.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "Driver")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDriver;
	@NotEmpty(message="Ingrese el nombre!")
	@Column(name = "nameDriver", nullable = false, length = 40)
	private String nameDriver;
	@NotEmpty(message="Ingrese el apellido!")
	@Column(name = "lastnameDriver",nullable =false, length = 40)
	private String lastnameDriver;
	@Min(20)
	@Max(40)
	@Column(name = "anios",nullable =false)
	private int anios;
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(int idDriver, @NotEmpty(message = "Ingrese el nombre!") String nameDriver,
			@NotEmpty(message = "Ingrese el apellido!") String lastnameDriver,
		    @Min(20) @Max(40) int anios) {
		super();
		this.idDriver = idDriver;
		this.nameDriver = nameDriver;
		this.lastnameDriver = lastnameDriver;
		this.anios = anios;
	}
	public int getIdDriver() {
		return idDriver;
	}
	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}
	public String getNameDriver() {
		return nameDriver;
	}
	public void setNameDriver(String nameDriver) {
		this.nameDriver = nameDriver;
	}
	public String getLastnameDriver() {
		return lastnameDriver;
	}
	public void setLastnameDriver(String lastnameDriver) {
		this.lastnameDriver = lastnameDriver;
	}
	public int getAnios() {
		return anios;
	}
	public void setAnios(int anios) {
		this.anios = anios;
	}
	
	
}
