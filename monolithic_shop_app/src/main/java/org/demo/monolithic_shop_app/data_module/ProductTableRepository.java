package org.demo.monolithic_shop_app.data_module;

import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductTableRepository extends ListPagingAndSortingRepository<ProductTable, String> {

}
