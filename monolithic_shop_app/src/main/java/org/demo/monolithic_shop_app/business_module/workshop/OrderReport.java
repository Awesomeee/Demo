package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;

public class OrderReport {
	
	private int totalOrderCount;
	private int requestingOrderCount;
	private int processingOrderCount;
	private int waitingForPaymentOrderCount;
	private int suspendedOrderCount;
	private int abortOrderCount;
	private int successfullyFinishOrderCount;
	private int cancelFinishOrderCount;
	private List<List<Order>> orderDatas;
	
	public OrderReport() {}
	
	public OrderReport(int totalOrderCount, int requestingOrderCount, int processingOrderCount, int waitingForPaymentOrderCount
			,int suspendedOrderCount, int abortOrderCount, int successfullyFinishOrderCount, int cancelFinishOrderCount, List<List<Order>> orderDatas) {
		this.totalOrderCount = totalOrderCount;
		this.requestingOrderCount = requestingOrderCount;
		this.processingOrderCount = processingOrderCount;
		this.waitingForPaymentOrderCount = waitingForPaymentOrderCount;
		this.suspendedOrderCount = suspendedOrderCount;
		this.abortOrderCount = abortOrderCount;
		this.successfullyFinishOrderCount = successfullyFinishOrderCount;
		this.cancelFinishOrderCount = cancelFinishOrderCount;
		this.orderDatas = orderDatas;
	}
	public int getTotalOrderCount() {
		return totalOrderCount;
	}
	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	public int getRequestingOrderCount() {
		return requestingOrderCount;
	}
	public void setRequestingOrderCount(int requestingOrderCount) {
		this.requestingOrderCount = requestingOrderCount;
	}
	public int getProcessingOrderCount() {
		return processingOrderCount;
	}
	public void setProcessingOrderCount(int processingOrderCount) {
		this.processingOrderCount = processingOrderCount;
	}
	public int getWaitingForPaymentOrderCount() {
		return waitingForPaymentOrderCount;
	}
	public void setWaitingForPaymentOrderCount(int waitingForPaymentOrderCount) {
		this.waitingForPaymentOrderCount = waitingForPaymentOrderCount;
	}
	public int getSuspendedOrderCount() {
		return suspendedOrderCount;
	}
	public void setSuspendedOrderCount(int suspendedOrderCount) {
		this.suspendedOrderCount = suspendedOrderCount;
	}
	public int getAbortOrderCount() {
		return abortOrderCount;
	}
	public void setAbortOrderCount(int abortOrderCount) {
		this.abortOrderCount = abortOrderCount;
	}
	public int getSuccessfullyFinishOrderCount() {
		return successfullyFinishOrderCount;
	}
	public void setSuccessfullyFinishOrderCount(int successfullyFinishOrderCount) {
		this.successfullyFinishOrderCount = successfullyFinishOrderCount;
	}
	public int getCancelFinishOrderCount() {
		return cancelFinishOrderCount;
	}
	public void setCancelFinishOrderCount(int cancelFinishOrderCount) {
		this.cancelFinishOrderCount = cancelFinishOrderCount;
	}
	public List<List<Order>> getOrderDatas() {
		return orderDatas;
	}
	public void setOrderDatas(List<List<Order>> orderDatas) {
		this.orderDatas = orderDatas;
	}

}
