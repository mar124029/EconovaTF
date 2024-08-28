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
@Table(name = "TypeSuscription")
public class TypeSuscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTypeSuscription;
	@NotEmpty(message = "El nombre es obligatorio")
	@Column(name = "nameSuscription", nullable = false, length = 80)
	private String nameSuscription;
	
	@Past
	@NotNull(message = "El fecha es obligatorio")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datestart", nullable = false)
	private Date datestart;
	@Future
	@NotNull(message = "El fecha es obligatorio")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dateend", nullable = false)
	private Date dateend;
	

	public TypeSuscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeSuscription(int idTypeSuscription,
			@NotEmpty(message = "El nombre es obligatorio") String nameSuscription,
			@Past @NotNull(message = "El fecha es obligatorio") Date datestart,
			@Future @NotNull(message = "El fecha es obligatorio") Date dateend) {
		super();
		this.idTypeSuscription = idTypeSuscription;
		this.nameSuscription = nameSuscription;
		this.datestart = datestart;
		this.dateend = dateend;
	}

	public int getIdTypeSuscription() {
		return idTypeSuscription;
	}

	public void setIdTypeSuscription(int idTypeSuscription) {
		this.idTypeSuscription = idTypeSuscription;
	}

	public String getNameSuscription() {
		return nameSuscription;
	}

	public void setNameSuscription(String nameSuscription) {
		this.nameSuscription = nameSuscription;
	}

	public Date getDatestart() {
		return datestart;
	}

	public void setDatestart(Date datestart) {
		this.datestart = datestart;
	}

	public Date getDateend() {
		return dateend;
	}

	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}
	
}
