package org.demo.monolithic_shop_app;

import static org.assertj.core.api.Assertions.assertThat;

import org.demo.monolithic_shop_app.web_service_module.shop.ProductApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonolithicShopAppApplicationTests {
	
	@Autowired
	private ProductApi productApi;

	@Test
	void contextLoads() {
		assertThat(productApi).isNotNull();
	}
	

}
