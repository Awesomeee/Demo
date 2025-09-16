package org.demo.monolithic_shop_app.data_module.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPurchaseItemTableRepository extends JpaRepository<OrderPurchaseItemTable, String> {

}
