package org.demo.monolithic_shop_app.data_module;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceTableRepository extends JpaRepository<InvoiceTable, String> {

}
