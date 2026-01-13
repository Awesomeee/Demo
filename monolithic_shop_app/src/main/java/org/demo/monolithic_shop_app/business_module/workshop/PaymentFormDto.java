package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class PaymentFormDto {
	
	private List<PaymentForm> paymentForms;
	
	public PaymentFormDto() {}
	
	public PaymentFormDto(List<PaymentForm> paymentForms) {
		this.paymentForms = paymentForms;
	}

	public List<PaymentForm> getPaymentForms() {
		return paymentForms;
	}

	public void setPaymentForms(List<PaymentForm> paymentForms) {
		this.paymentForms = paymentForms;
	}

}
