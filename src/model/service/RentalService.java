package model.service;

import java.time.Duration;

import modal.entities.CarRental;
import modal.entities.Invoice;

public class RentalService {
	
	private Double pricePerHour;
	private Double pricePerDay;
	
	private TaxService taxService;

	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		super();
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}



	public void processInvoice(CarRental carRental) {
		
		double minutes = Duration.between(carRental.getStar(), carRental.getFinish()).toMinutes();
		double hours = minutes / 60.0;
		
		double basicPayment;
		if(hours <= 12.0)	{
			basicPayment = pricePerHour * Math.ceil(hours);
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24);
		}
		
		double taxPayment = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, taxPayment));
	}
	
}
