package org.demo.monolithic_shop_app.data_module.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSaleItemTableRepository extends JpaRepository<OrderSaleItemTable, String> {

	public List<OrderSaleItemTable> findByOrderId(String orderId);
	public void deleteAllByOrderId(String orderId);
}
