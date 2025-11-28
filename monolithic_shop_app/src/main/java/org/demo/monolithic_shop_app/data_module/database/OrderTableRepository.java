package org.demo.monolithic_shop_app.data_module.database;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTableRepository extends JpaRepository<OrderTable, String> {
	
	//List<Event> findByEventTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
	
	//@Query("SELECT e FROM Event e WHERE e.eventTime BETWEEN ?1 AND ?2")
    //List<Event> findEventsInDateRange(LocalDateTime startDateTime, LocalDateTime endDateTime);
	
	/*
	Inclusivity: The BETWEEN operator in SQL (and consequently in JPQL) is inclusive, meaning it includes the startDateTime and endDateTime values in the result set. If you need exclusive ranges, consider using GreaterThan and LessThan or GreaterThanEqual and LessThanEqual in your query methods or JPQL.
	*/
	
	List<OrderTable> findByCreatedDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
