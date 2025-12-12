package org.demo.monolithic_shop_app.business_module.workshop;

import java.util.List;


public class EmployeeDto {

	private List<Employee> employees;
	
	public EmployeeDto() {}
	
	public EmployeeDto(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
