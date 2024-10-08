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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ListVaccination")
public class ListVaccination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idListVaccination;
	@NotNull(message = "La fecha es obligatorio")
	@Past(message = "La fecha es en el pasado")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateVaccination", nullable = false)
	private Date dateVaccination;
	@NotNull(message = "El número de dosis es obligatorio")
	@Min(1)
	@Max(5)
	@Column(name = "numberOfDose", nullable = false)
	private int numberOfDose;

	@ManyToOne
	@JoinColumn(name = "idVaccine")
	private Vaccine vaccine;
	@ManyToOne
	@JoinColumn(name = "idDriver")
	private Driver driver;

	public ListVaccination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListVaccination(int idListVaccination,
			@NotNull(message = "La fecha es obligatorio") @Past(message = "La fecha es en el pasado") Date dateVaccination,
			@NotNull(message = "El número de dosis es obligatorio") @Min(1) @Max(5) int numberOfDose, Vaccine vaccine,
			Driver driver) {
		super();
		this.idListVaccination = idListVaccination;
		this.dateVaccination = dateVaccination;
		this.numberOfDose = numberOfDose;
		this.vaccine = vaccine;
		this.driver = driver;
	}

	public int getIdListVaccination() {
		return idListVaccination;
	}

	public void setIdListVaccination(int idListVaccination) {
		this.idListVaccination = idListVaccination;
	}

	public Date getDateVaccination() {
		return dateVaccination;
	}

	public void setDateVaccination(Date dateVaccination) {
		this.dateVaccination = dateVaccination;
	}

	public int getNumberOfDose() {
		return numberOfDose;
	}

	public void setNumberOfDose(int numberOfDose) {
		this.numberOfDose = numberOfDose;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	

}
