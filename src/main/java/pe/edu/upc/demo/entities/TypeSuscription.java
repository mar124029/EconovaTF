package pe.edu.upc.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

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
	
	private String image;
	

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

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
