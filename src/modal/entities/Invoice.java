package modal.entities;

public class Invoice {
	
	private Double basicPayment;
	private Double taxPayment;
	
	public Invoice() {
	}

	public Invoice(Double basicPayment, Double taxPayment) {
		this.basicPayment = basicPayment;
		this.taxPayment = taxPayment;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTaxPayment() {
		return taxPayment;
	}

	public void setTaxPayment(Double taxPayment) {
		this.taxPayment = taxPayment;
	}
	
	public Double totalPayment() {
		return getBasicPayment() + getTaxPayment();
	}
	
	
}
