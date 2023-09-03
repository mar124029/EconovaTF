package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Company")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCompany;
	@NotEmpty(message = "El nombre es obligatorio")
	@Column(name = "nameCompany", length = 50,nullable = false)
	private String nameCompany;
	@NotNull(message = "El RUC es obligatorio")
	@Size(min=11,max=11)
	@Positive
	@Column(name = "ruCompany", length = 11,nullable = false)
	private String ruCompany;
	@NotNull(message = "El telefono es obligatorio")
	@Size(min=9,max=9)
	@Positive
	@Column(name = "phoneCompany", length = 9,nullable = false)
	private String phoneCompany;
	
	@NotEmpty(message = "La dirección es obligatorio")
	@Column(name = "addressCompany", length = 80,nullable = false)
	private String addressCompany;
	
	@ManyToOne
	@JoinColumn(name = "idTypeSuscription")
	private TypeSuscription typesuscription;

	public Empresa() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Empresa(int idCompany, @NotEmpty(message = "El nombre es obligatorio") String nameCompany,
			@NotNull(message = "El RUC es obligatorio") @Size(min = 11, max = 11) @Positive String ruCompany,
			@NotNull(message = "El telefono es obligatorio") @Size(min = 9, max = 9) @Positive String phoneCompany,
			@NotEmpty(message = "La dirección es obligatorio") String addressCompany, TypeSuscription typesuscription) {
		super();
		this.idCompany = idCompany;
		this.nameCompany = nameCompany;
		this.ruCompany = ruCompany;
		this.phoneCompany = phoneCompany;
		this.addressCompany = addressCompany;
		this.typesuscription = typesuscription;
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getRuCompany() {
		return ruCompany;
	}

	public void setRuCompany(String ruCompany) {
		this.ruCompany = ruCompany;
	}

	public String getPhoneCompany() {
		return phoneCompany;
	}

	public void setPhoneCompany(String phoneCompany) {
		this.phoneCompany = phoneCompany;
	}

	public String getAddressCompany() {
		return addressCompany;
	}

	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}

	public TypeSuscription getTypesuscription() {
		return typesuscription;
	}

	public void setTypesuscription(TypeSuscription typesuscription) {
		this.typesuscription = typesuscription;
	}

	
	
	
	
}
