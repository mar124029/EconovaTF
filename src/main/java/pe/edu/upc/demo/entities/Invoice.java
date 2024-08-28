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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInvoice;
	
	@NotNull(message = "El monto es obligatorio")
	@Min(100)
	@Max(100000000)
	@Column(name="mont",nullable = false, length = 10)
	private int mont;
	
	
	@NotNull(message = "El fecha es obligatorio")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="datepayment",nullable = false)
	private Date datepayment;
	
	@ManyToOne
	@JoinColumn(name = "idService")
	private Service service;

	public Invoice() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Invoice(int idInvoice, @NotNull(message = "El monto es obligatorio") @Min(100) @Max(100000000) int mont,
			@NotNull(message = "El fecha es obligatorio") Date datepayment,
			Service service) {
		super();
		this.idInvoice = idInvoice;
		this.mont = mont;
		this.datepayment = datepayment;
		this.service = service;
	}

	public int getIdInvoice() {
		return idInvoice;
	}

	public void setIdInvoice(int idInvoice) {
		this.idInvoice = idInvoice;
	}

	public int getMont() {
		return mont;
	}

	public void setMont(int mont) {
		this.mont = mont;
	}

	public Date getDatepayment() {
		return datepayment;
	}

	public void setDatepayment(Date datepayment) {
		this.datepayment = datepayment;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}


	
	
	
}
