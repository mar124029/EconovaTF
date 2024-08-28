package pe.edu.upc.demo.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Vaccine")
public class Vaccine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVaccine;
	@NotEmpty(message = "La descripción es obligatorio")
	@Column(name = "descriptionVaccine",nullable = false, length = 100)
	private String descriptionVaccine;
	@Past
	@NotNull(message = "El fecha es obligatorio")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateFrabication",nullable = false)
	private Date dateFrabication;
	@Future
	@NotNull(message = "El fecha es obligatorio")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateExpiration",nullable = false)
	private Date dateExpiration;
	
	public Vaccine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vaccine(int idVaccine, @NotEmpty(message = "La descripción es obligatorio") String descriptionVaccine,
			@Past @NotNull(message = "El fecha es obligatorio") Date dateFrabication,
			@Future @NotNull(message = "El fecha es obligatorio") Date dateExpiration) {
		super();
		this.idVaccine = idVaccine;
		this.descriptionVaccine = descriptionVaccine;
		this.dateFrabication = dateFrabication;
		this.dateExpiration = dateExpiration;
	}

	public int getIdVaccine() {
		return idVaccine;
	}

	public void setIdVaccine(int idVaccine) {
		this.idVaccine = idVaccine;
	}

	public String getDescriptionVaccine() {
		return descriptionVaccine;
	}

	public void setDescriptionVaccine(String descriptionVaccine) {
		this.descriptionVaccine = descriptionVaccine;
	}

	public Date getDateFrabication() {
		return dateFrabication;
	}

	public void setDateFrabication(Date dateFrabication) {
		this.dateFrabication = dateFrabication;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	
	
	
}
