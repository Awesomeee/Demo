package org.demo.monolithic_shop_app.data_module.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductTableRepository extends JpaRepository<ProductTable, String> {

	public int countByCategory(String category);
	//public List<String> findDistinctCategory();
	//example custom query - duyl, Tue 6 Jan, 2026
	@Query("SELECT DISTINCT a.category FROM ProductTable a")
    List<String> findDistinctCategoryByQuery();
}
