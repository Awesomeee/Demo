package org.demo.monolithic_shop_app.business_module;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.demo.monolithic_shop_app.business_module.shop.Customer;
import org.demo.monolithic_shop_app.business_module.shop.CustomerDto;
import org.demo.monolithic_shop_app.business_module.workshop.Order;
import org.demo.monolithic_shop_app.business_module.workshop.OrderDto;
import org.demo.monolithic_shop_app.business_module.workshop.OrderItem;
import org.demo.monolithic_shop_app.business_module.workshop.OrderReport;
import org.demo.monolithic_shop_app.business_module.workshop.Product;
import org.demo.monolithic_shop_app.business_module.workshop.ProductDto;
import org.demo.monolithic_shop_app.data_module.database.CustomerTable;
import org.demo.monolithic_shop_app.data_module.database.CustomerTableRepository;
import org.demo.monolithic_shop_app.data_module.database.OrderSaleItemTable;
import org.demo.monolithic_shop_app.data_module.database.OrderSaleItemTableRepository;
import org.demo.monolithic_shop_app.data_module.database.OrderTable;
import org.demo.monolithic_shop_app.data_module.database.OrderTableRepository;
import org.demo.monolithic_shop_app.data_module.database.ProductTable;
import org.demo.monolithic_shop_app.data_module.database.ProductTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service(value = "BusinessBean")
public class BusinessService {
	
	@Autowired
	private ProductTableRepository productTableRepository;
	@Autowired
	private CustomerTableRepository customerTableRepository;
	@Autowired
	private OrderTableRepository orderTableRepository;
	@Autowired
	private OrderSaleItemTableRepository orderSaleItemTableRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	private ProductDto products;
	
	public BusinessService() {
		setProducts(new ProductDto());
	}

	public ProductDto getProducts() {
		return products;
	}

	public void setProducts(ProductDto products) {
		this.products = products;
	}
	
	//Product Section
	public ProductDto queryAllProducts(int pageNumber, int pageSize, String sortType, String direction) {
		Sort sort = Sort.by(sortType);
		if(direction.equals("asc")) {
			sort = sort.ascending();
		} else if(direction.equals("desc")) {
			sort = sort.descending();
		}
		List<ProductTable> rows = productTableRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
		List<Product> products = new ArrayList<Product>();
		for(int i=0; i<rows.size();i++) {
			Product element = new Product();
			element.setId(rows.get(i).getId());
			element.setName(rows.get(i).getName());
			element.setDescription(rows.get(i).getDescription());
			element.setPrice(rows.get(i).getPrice());
			element.setCurrency(rows.get(i).getCurrency());
			element.setProvider(rows.get(i).getProvider());
			
			products.add(element);
		}
		ProductDto result = new ProductDto();
		result.setProducts(products);
		return result;
	}
	
	public int createNewProductResource(Product product) {
		int result = 1;
		try {
			ProductTable row = new ProductTable(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCurrency(), product.getProvider());
			productTableRepository.save(row);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int updateProduct(String id, Product product) {
		int result = 1;
		try {
			Optional<ProductTable> updateRow = productTableRepository.findById(id);
			updateRow.get().setName(product.getName());
			updateRow.get().setDescription(product.getDescription());
			updateRow.get().setPrice(product.getPrice());
			updateRow.get().setCurrency(product.getCurrency());
			updateRow.get().setProvider(product.getProvider());
			productTableRepository.save(updateRow.get());
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public List<ProductTable> queryProductByDynamicallyConditions(HashMap<String, String> conditions) {
		String jpql = "SELECT p FROM ProductTable p Where ";
		boolean firstCondition = true;
		for(String data: conditions.keySet()) {
			if(firstCondition) {
				jpql = jpql + "p." + data + " = :" + data + " ";
				firstCondition = false;
			} else {
				jpql = jpql + "AND p." + data + " = :" + data + " ";
			}
			
		}
		
		System.out.println(jpql);
		TypedQuery<ProductTable> query = entityManager.createQuery(jpql, ProductTable.class);
		for(String data: conditions.keySet()) {
			query.setParameter(data, conditions.get(data));
		}
		
		
		return query.getResultList();
	}
	
	public int updatePartialProduct(String id, HashMap<String, String> updateDatas) {
		int result = 1;
		try {
			Optional<ProductTable> updateRow = productTableRepository.findById(id);
			Field[] fields = updateRow.get().getClass().getDeclaredFields();
			
			boolean isUpdate = false;
			for(String data: updateDatas.keySet()) {
				for(int i=0;i<fields.length;i++) {
					if(fields[i].getName().equals(data)) {
						//update object data
						updateRow.get().getClass().getMethod("set" + data.substring(0, 1).toUpperCase() + data.substring(1), String.class).invoke(updateRow.get(), updateDatas.get(data));
						isUpdate = true;
						break;
					}
				}
				
			}
			
			if(isUpdate)
				productTableRepository.save(updateRow.get());
		
		} catch(Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int deleteProductById(String id) {
		int result = 1;
		try {
			productTableRepository.deleteById(id);
		} catch(Exception e) {
			result = 0;
			System.err. print(e.getMessage());
		}
		return result;
	}
	
	//Customer Section
	public CustomerDto queryAllCustomers(int pageNumber, int pageSize, String sortType, String direction) {
		Sort sort = Sort.by(sortType);
		if(direction.equals("asc")) {
			sort = sort.ascending();
		} else if(direction.equals("desc")) {
			sort = sort.descending();
		}
		List<CustomerTable> rows = customerTableRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
		List<Customer> customers = new ArrayList<Customer>();
		for(int i=0; i<rows.size();i++) {
			Customer element = new Customer();
			element.setCustomerId(rows.get(i).getCustomerId());
			element.setCustomerName(rows.get(i).getCustomerName());
			element.setPhoneNumber(rows.get(i).getPhoneNumber());
			element.setEmail(rows.get(i).getEmail());
			element.setAddress(rows.get(i).getAddress());
			element.setIdentityNumber(rows.get(i).getIdentityNumber());
			
			customers.add(element);
		}
		CustomerDto result = new CustomerDto();
		result.setCustomers(customers);
		return result;
	}
	
	public int createNewCustomerResource(Customer customer) {
		int result = 1;
		try {
			CustomerTable row = new CustomerTable(customer.getCustomerId(), customer.getCustomerName(), customer.getPhoneNumber()
												, customer.getEmail(), customer.getAddress(), customer.getIdentityNumber(), null);
			customerTableRepository.save(row);
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int updateCustomer(String id, Customer customer) {
		int result = 1;
		try {
			Optional<CustomerTable> updateRow = customerTableRepository.findById(id);
			updateRow.get().setCustomerName(customer.getCustomerName());
			updateRow.get().setPhoneNumber(customer.getPhoneNumber());
			updateRow.get().setEmail(customer.getEmail());
			updateRow.get().setAddress(customer.getAddress());
			updateRow.get().setIdentityNumber(customer.getIdentityNumber());
			customerTableRepository.save(updateRow.get());
		} catch (Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public List<CustomerTable> queryCustomerByDynamicallyConditions(HashMap<String, String> conditions) {
		String jpql = "SELECT c FROM CustomerTable c Where ";
		boolean firstCondition = true;
		for(String data: conditions.keySet()) {
			if(firstCondition) {
				jpql = jpql + "c." + data + " = :" + data + " ";
				firstCondition = false;
			} else {
				jpql = jpql + "AND c." + data + " = :" + data + " ";
			}
			
		}
		
		System.out.println(jpql);
		TypedQuery<CustomerTable> query = entityManager.createQuery(jpql, CustomerTable.class);
		for(String data: conditions.keySet()) {
			query.setParameter(data, conditions.get(data));
		}
		
		
		return query.getResultList();
	}
	
	public int updatePartialCustomer(String id, HashMap<String, String> updateDatas) {
		int result = 1;
		try {
			Optional<CustomerTable> updateRow = customerTableRepository.findById(id);
			Field[] fields = updateRow.get().getClass().getDeclaredFields();
			
			boolean isUpdate = false;
			for(String data: updateDatas.keySet()) {
				for(int i=0;i<fields.length;i++) {
					if(fields[i].getName().equals(data)) {
						//update object data
						updateRow.get().getClass().getMethod("set" + data.substring(0, 1).toUpperCase() + data.substring(1), String.class).invoke(updateRow.get(), updateDatas.get(data));
						isUpdate = true;
						break;
					}
				}
				
			}
			
			if(isUpdate)
				customerTableRepository.save(updateRow.get());
		
		} catch(Exception e) {
			result = 0;
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public int deleteCustomerById(String id) {
		int result = 1;
		try {
			customerTableRepository.deleteById(id);
		} catch(Exception e) {
			result = 0;
			System.err. print(e.getMessage());
		}
		return result;
	}
	
	//Order Section
	public OrderDto queryAllOrders(int pageNumber, int pageSize, String sortType, String direction) {
		Sort sort = Sort.by(sortType);
		if(direction.equals("asc")) {
			sort = sort.ascending();
		} else if(direction.equals("desc")) {
			sort = sort.descending();
		}
		List<OrderTable> rows = orderTableRepository.findAll(PageRequest.of(pageNumber, pageSize, sort)).getContent();
		List<Order> orders = new ArrayList<Order>();
		for(int i=0; i<rows.size();i++) {
			Order element = new Order();
			element.setOrderId(rows.get(i).getOrderId());
			element.setAfterTaxTotal(rows.get(i).getAfterTaxTotal());
			element.setBeforeTaxTotal(rows.get(i).getBeforeTaxTotal());
			element.setCreatedDate(rows.get(i).getCreatedDateTime());
			element.setCreatedPerson(rows.get(i).getCreatedPerson());
			element.setCurrency(rows.get(i).getCurrency());
			element.setCustomer(rows.get(i).getCustomer());
			element.setTaxRatio(rows.get(i).getTaxRatio());
			
			List<OrderItem> oiList = new ArrayList<OrderItem>();
			List<OrderSaleItemTable> saleItemList = orderSaleItemTableRepository.findByOrderId(rows.get(i).getOrderId());
			for(int j=0;j<saleItemList.size();j++) {
				OrderItem item = new OrderItem(saleItemList.get(i).getNumber()
						, new Product(saleItemList.get(i).getProduct().getId(), saleItemList.get(i).getProduct().getName(), saleItemList.get(i).getProduct().getDescription(), saleItemList.get(i).getProduct().getPrice(), saleItemList.get(i).getProduct().getCurrency(), saleItemList.get(i).getProduct().getProvider(), null)
						, saleItemList.get(i).getQuanity(), saleItemList.get(i).getAmount());
				oiList.add(item);
			}
			element.setItemList(oiList);
			
			orders.add(element);
		}
		OrderDto result = new OrderDto();
		result.setOrders(orders);
		return result;
	}
	
	@Transactional
	public int createNewOrderResource(Order order, Customer customer, List<OrderSaleItemTable> saleItems) {
		int result = 1;		//0: some error happened, 1: successfully, 2: customer not found, 3: product not found
		Optional<CustomerTable> customerChecking = customerTableRepository.findById(customer.getCustomerId());
		if(customerChecking.isEmpty()) {
			result = 2;
		} else {
			for(int i=0;i<saleItems.size();i++) {
				Optional<ProductTable> productItemChecking = productTableRepository.findById(saleItems.get(i).getProduct().getId());
				if(productItemChecking.isEmpty()) {
					result = 3;
					return result;
				}
			}
			//If customer existed and all of the product existed then the system will insert new Order data into database
			try {
				for(int i=0;i<saleItems.size();i++) {
					OrderSaleItemTable osi = new OrderSaleItemTable(saleItems.get(i).getItemId(), saleItems.get(i).getOrder()
											, saleItems.get(i).getProduct(), saleItems.get(i).getNumber()
											, saleItems.get(i).getQuanity(), saleItems.get(i).getAmount()
											, customer.getCustomerId());
					orderSaleItemTableRepository.save(osi);
				}
				OrderTable orderRecord = new OrderTable(order.getOrderId(), order.getCreatedDate(), order.getCreatedPerson(), customer.getCustomerId(), order.getBeforeTaxTotal(), order.getTaxRatio(), order.getAfterTaxTotal(), order.getCurrency(), order.getState());
				orderTableRepository.save(orderRecord);
			} catch (Exception e) {
				result = 0;
				System.err. print(e.getMessage());
			}
		}
		return result;
	}
	
	@Transactional
	public int updateOrder(String id, Order order, Customer customer, List<OrderSaleItemTable> saleItems) {
		int result = 1;		//0: some error happened, 1: successfully, 2: customer not found, 3: product not found
		Optional<CustomerTable> customerChecking = customerTableRepository.findById(customer.getCustomerId());
		if(customerChecking.isEmpty()) {
			result = 2;
		} else {
			for(int i=0;i<saleItems.size();i++) {
				Optional<ProductTable> productItemChecking = productTableRepository.findById(saleItems.get(i).getProduct().getId());
				if(productItemChecking.isEmpty()) {
					result = 3;
					return result;
				}
			}
			//If customer existed and all of the product existed then the system will update new Order data into database
			try {
				/*
				 * Author: duyl, created date: Tue, 25 Nov 2025
				 * Update logic: firstly, delete all sale order items that have value of orderId
				 * 				secondly, insert all new sale order items from the input
				 * 				lastly, update all columns of the Order record with the new value
				 */
				orderSaleItemTableRepository.deleteAllByOrderId(order.getOrderId());
				for(int i=0;i<saleItems.size();i++) {
					OrderSaleItemTable osi = new OrderSaleItemTable(saleItems.get(i).getItemId(), saleItems.get(i).getOrder()
											, saleItems.get(i).getProduct(), saleItems.get(i).getNumber()
											, saleItems.get(i).getQuanity(), saleItems.get(i).getAmount()
											, customer.getCustomerId());
					orderSaleItemTableRepository.save(osi);
				}
				Optional<OrderTable> updateRow = orderTableRepository.findById(id);
				updateRow.get().setCustomer(customer.getCustomerName());
				updateRow.get().setCurrency(order.getCurrency());
				updateRow.get().setCreatedPerson(order.getCreatedPerson());
				updateRow.get().setCreatedDateTime(order.getCreatedDate());
				updateRow.get().setBeforeTaxTotal(order.getBeforeTaxTotal());
				updateRow.get().setAfterTaxTotal(order.getAfterTaxTotal());
				updateRow.get().setTaxRatio(order.getTaxRatio());
				orderTableRepository.save(updateRow.get());
			} catch (Exception e) {
				result = 0;
				System.err. print(e.getMessage());
			}
		}
		return result;
	}
	
	public List<OrderTable> queryOrderByDynamicallyConditions(HashMap<String, String> conditions) {
		return null;
	}
	
	public int updatePartialOrder(String id, HashMap<String, String> updateDatas) {
		return 0;
	}
	
	@Transactional
	public int deleteOrderById(String id) {
		int result = 1;
		try {
			List<OrderSaleItemTable> osiList = orderSaleItemTableRepository.findByOrderId(id);
			for(int i=0; i<osiList.size();i++) {
				orderSaleItemTableRepository.deleteById(osiList.get(i).getItemId());
			}
			orderTableRepository.deleteById(id);
		} catch(Exception e) {
			result = 0;
			System.err. print(e.getMessage());
		}
		return result;
	}
	
	public OrderDto reportOrdersInCurrentDay() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime fromStartOfTheDay = LocalDateTime.of(currentTime.getYear(), currentTime.getMonth()
										, currentTime.getDayOfMonth(), 0, 0, 0);
		List<OrderTable> rows = orderTableRepository.findByCreatedDateTimeBetween(fromStartOfTheDay, currentTime);
		List<Order> orders = new ArrayList<Order>();
		for(int i=0; i<rows.size();i++) {
			Order element = new Order();
			element.setOrderId(rows.get(i).getOrderId());
			element.setAfterTaxTotal(rows.get(i).getAfterTaxTotal());
			element.setBeforeTaxTotal(rows.get(i).getBeforeTaxTotal());
			element.setCreatedDate(rows.get(i).getCreatedDateTime());
			element.setCreatedPerson(rows.get(i).getCreatedPerson());
			element.setCurrency(rows.get(i).getCurrency());
			element.setCustomer(rows.get(i).getCustomer());
			element.setTaxRatio(rows.get(i).getTaxRatio());
			
			List<OrderItem> oiList = new ArrayList<OrderItem>();
			List<OrderSaleItemTable> saleItemList = orderSaleItemTableRepository.findByOrderId(rows.get(i).getOrderId());
			for(int j=0;j<saleItemList.size();j++) {
				OrderItem item = new OrderItem(saleItemList.get(i).getNumber()
						, new Product(saleItemList.get(i).getProduct().getId(), saleItemList.get(i).getProduct().getName(), saleItemList.get(i).getProduct().getDescription(), saleItemList.get(i).getProduct().getPrice(), saleItemList.get(i).getProduct().getCurrency(), saleItemList.get(i).getProduct().getProvider(), null)
						, saleItemList.get(i).getQuanity(), saleItemList.get(i).getAmount());
				oiList.add(item);
			}
			element.setItemList(oiList);
			
			orders.add(element);
		}
		OrderDto result = new OrderDto();
		result.setOrders(orders);
		return result;
	}
	
	public OrderDto reportOrdersInCurrentMonth() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime fromStartOfTheMonth = LocalDateTime.of(currentTime.getYear(), currentTime.getMonth(), 1, 0, 0, 0);
		List<OrderTable> rows = orderTableRepository.findByCreatedDateTimeBetween(fromStartOfTheMonth, currentTime);
		List<Order> orders = new ArrayList<Order>();
		for(int i=0; i<rows.size();i++) {
			Order element = new Order();
			element.setOrderId(rows.get(i).getOrderId());
			element.setAfterTaxTotal(rows.get(i).getAfterTaxTotal());
			element.setBeforeTaxTotal(rows.get(i).getBeforeTaxTotal());
			element.setCreatedDate(rows.get(i).getCreatedDateTime());
			element.setCreatedPerson(rows.get(i).getCreatedPerson());
			element.setCurrency(rows.get(i).getCurrency());
			element.setCustomer(rows.get(i).getCustomer());
			element.setTaxRatio(rows.get(i).getTaxRatio());
			
			List<OrderItem> oiList = new ArrayList<OrderItem>();
			List<OrderSaleItemTable> saleItemList = orderSaleItemTableRepository.findByOrderId(rows.get(i).getOrderId());
			for(int j=0;j<saleItemList.size();j++) {
				OrderItem item = new OrderItem(saleItemList.get(i).getNumber()
						, new Product(saleItemList.get(i).getProduct().getId(), saleItemList.get(i).getProduct().getName(), saleItemList.get(i).getProduct().getDescription(), saleItemList.get(i).getProduct().getPrice(), saleItemList.get(i).getProduct().getCurrency(), saleItemList.get(i).getProduct().getProvider(), null)
						, saleItemList.get(i).getQuanity(), saleItemList.get(i).getAmount());
				oiList.add(item);
			}
			element.setItemList(oiList);
			
			orders.add(element);
		}
		OrderDto result = new OrderDto();
		result.setOrders(orders);
		return result;
	}
	
	public OrderDto reportOrdersInCurrentYear() {
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDateTime fromStartOfTheYear = LocalDateTime.of(currentTime.getYear(), 1, 1, 0, 0, 0);
		List<OrderTable> rows = orderTableRepository.findByCreatedDateTimeBetween(fromStartOfTheYear, currentTime);
		List<Order> orders = new ArrayList<Order>();
		for(int i=0; i<rows.size();i++) {
			Order element = new Order();
			element.setOrderId(rows.get(i).getOrderId());
			element.setAfterTaxTotal(rows.get(i).getAfterTaxTotal());
			element.setBeforeTaxTotal(rows.get(i).getBeforeTaxTotal());
			element.setCreatedDate(rows.get(i).getCreatedDateTime());
			element.setCreatedPerson(rows.get(i).getCreatedPerson());
			element.setCurrency(rows.get(i).getCurrency());
			element.setCustomer(rows.get(i).getCustomer());
			element.setTaxRatio(rows.get(i).getTaxRatio());
			
			List<OrderItem> oiList = new ArrayList<OrderItem>();
			List<OrderSaleItemTable> saleItemList = orderSaleItemTableRepository.findByOrderId(rows.get(i).getOrderId());
			for(int j=0;j<saleItemList.size();j++) {
				OrderItem item = new OrderItem(saleItemList.get(i).getNumber()
						, new Product(saleItemList.get(i).getProduct().getId(), saleItemList.get(i).getProduct().getName(), saleItemList.get(i).getProduct().getDescription(), saleItemList.get(i).getProduct().getPrice(), saleItemList.get(i).getProduct().getCurrency(), saleItemList.get(i).getProduct().getProvider(), null)
						, saleItemList.get(i).getQuanity(), saleItemList.get(i).getAmount());
				oiList.add(item);
			}
			element.setItemList(oiList);
			
			orders.add(element);
		}
		OrderDto result = new OrderDto();
		result.setOrders(orders);
		return result;
	}
	
	public OrderDto reportOrdersInAYear(int year) {
		LocalDateTime fromYear = LocalDateTime.of(year, 1, 1, 0, 0, 0);
		LocalDateTime toYear = LocalDateTime.of(year, 12, 31, 0, 0, 0);
		List<OrderTable> rows = orderTableRepository.findByCreatedDateTimeBetween(fromYear, toYear);
		List<Order> orders = new ArrayList<Order>();
		for(int i=0; i<rows.size();i++) {
			Order element = new Order();
			element.setOrderId(rows.get(i).getOrderId());
			element.setAfterTaxTotal(rows.get(i).getAfterTaxTotal());
			element.setBeforeTaxTotal(rows.get(i).getBeforeTaxTotal());
			element.setCreatedDate(rows.get(i).getCreatedDateTime());
			element.setCreatedPerson(rows.get(i).getCreatedPerson());
			element.setCurrency(rows.get(i).getCurrency());
			element.setCustomer(rows.get(i).getCustomer());
			element.setTaxRatio(rows.get(i).getTaxRatio());
			
			List<OrderItem> oiList = new ArrayList<OrderItem>();
			List<OrderSaleItemTable> saleItemList = orderSaleItemTableRepository.findByOrderId(rows.get(i).getOrderId());
			for(int j=0;j<saleItemList.size();j++) {
				OrderItem item = new OrderItem(saleItemList.get(i).getNumber()
						, new Product(saleItemList.get(i).getProduct().getId(), saleItemList.get(i).getProduct().getName(), saleItemList.get(i).getProduct().getDescription(), saleItemList.get(i).getProduct().getPrice(), saleItemList.get(i).getProduct().getCurrency(), saleItemList.get(i).getProduct().getProvider(), null)
						, saleItemList.get(i).getQuanity(), saleItemList.get(i).getAmount());
				oiList.add(item);
			}
			element.setItemList(oiList);
			
			orders.add(element);
		}
		OrderDto result = new OrderDto();
		result.setOrders(orders);
		return result;
	}
	
	public OrderReport reportStatisticallyOrderDataInCurrentDay() {
		OrderDto orders = reportOrdersInCurrentDay();
		int requestingCount = 0;
		int processingCount = 0;
		int waitingForPaymentCount = 0;
		int suspendedCount = 0;
		int abortedCount = 0;
		int successfullyFinishCount = 0;
		int cancelFinishCount = 0;
		List<List<Order>> statisticOrderList = new ArrayList<List<Order>>();
		statisticOrderList.add(new ArrayList<Order>());		//index 0:requesting
		statisticOrderList.add(new ArrayList<Order>());		//index 1:processing
		statisticOrderList.add(new ArrayList<Order>());		//index 2:waiting for payment
		statisticOrderList.add(new ArrayList<Order>());		//index 3:suspended
		statisticOrderList.add(new ArrayList<Order>());		//index 4:aborted
		statisticOrderList.add(new ArrayList<Order>());		//index 5:finish successfully
		statisticOrderList.add(new ArrayList<Order>());		//index 6:cancel finish
		for(int i=0; i < orders.getOrders().size(); i++) {
			if(orders.getOrders().get(i).getState().equals("REQUESTING")) {
				requestingCount++;
				statisticOrderList.get(0).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("PROCESSING")) {
				processingCount++;
				statisticOrderList.get(1).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("WAITING_FOR_PAYMENT")) {
				waitingForPaymentCount++;
				statisticOrderList.get(2).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("SUSPENDED")) {
				suspendedCount++;
				statisticOrderList.get(3).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("ABORTED")) {
				abortedCount++;
				statisticOrderList.get(4).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("FINISH_SUCCESSFULLY")) {
				successfullyFinishCount++;
				statisticOrderList.get(5).add(orders.getOrders().get(i));
			} else if(orders.getOrders().get(i).getState().equals("FINISH_CANCEL")) {
				cancelFinishCount++;
				statisticOrderList.get(6).add(orders.getOrders().get(i));
			}
		}
		int total = requestingCount + processingCount + waitingForPaymentCount + suspendedCount + abortedCount + successfullyFinishCount + cancelFinishCount;
		OrderReport orderReport = new OrderReport(total, requestingCount, processingCount, waitingForPaymentCount, suspendedCount
										, abortedCount, successfullyFinishCount, cancelFinishCount, statisticOrderList);
		
		return orderReport;
	}

}
