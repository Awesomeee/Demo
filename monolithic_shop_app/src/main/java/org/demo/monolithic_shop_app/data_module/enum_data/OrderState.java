package org.demo.monolithic_shop_app.data_module.enum_data;

public enum OrderState {
	REQUESTED,
	WAITING_FOR_PROCESS,
	PROCESSING,
	WAITING_FOR_PAYMENT,
	FINISH,
	ABORT,
	CANCEL
}
