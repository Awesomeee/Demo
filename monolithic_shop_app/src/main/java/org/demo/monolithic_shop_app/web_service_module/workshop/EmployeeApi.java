package org.demo.monolithic_shop_app.web_service_module.workshop;

import java.util.HashMap;

import org.demo.monolithic_shop_app.business_module.BusinessService;
import org.demo.monolithic_shop_app.business_module.workshop.Employee;
import org.demo.monolithic_shop_app.business_module.workshop.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class EmployeeApi {
	
	@Autowired
	private BusinessService businessService;
	
	@GetMapping("/api/employees")
	public EmployeeDto queryAllEmployees(@RequestParam(name = "page", required = false) int page, @RequestParam(name = "size", required = false) int size
									,@RequestParam(name = "sort", required = false) String sort, @RequestParam(name = "direction", required = false) String direction) {
		return businessService.queryAllEmployees(page, size, sort, direction);
	}
	
	@PostMapping("/api/employees")
	public String createEmployee(@Valid @RequestBody(required = true) Employee employee) {
		return businessService.createNewEmployeeResource(employee) + "";
	}
	
	@GetMapping("/api/employees/conditions")
	public String queryEmployeesListByConditions(HashMap<String, String> conditionMap) {
		return "empty";
	}
	
	@PatchMapping("/api/employees/{employee-id}")
	public String updateParticallyEmployee(@PathVariable(name = "employee-id") String employeeId, @Valid @RequestBody(required = true) EmployeeDto employee) {
		return "empty";
	}
	
	@PutMapping("/api/employees/{employee-id}")
	public String updateEmployee(@PathVariable(name="employee-id") String employeeId, @Valid @RequestBody(required = true) Employee employee) {
		return businessService.updateEmployee(employeeId, employee) + "";
	}
	
	@DeleteMapping("/api/employees/{employee-id}")
	public String deleteEmployee(@PathVariable(name = "employee-id") String employeeId) {
		return businessService.deleteEmployee(employeeId) + "";
	}

}
