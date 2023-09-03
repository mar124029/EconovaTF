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
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

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
