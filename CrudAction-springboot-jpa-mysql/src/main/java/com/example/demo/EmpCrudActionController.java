package com.example.demo;

/**
 * 
 * @author prathapa
 * 
 * EmpCrudActionController : Acts as rest end point to serve the client request
 * 
 * NOTE:- Four Types of methods/services are written to provide the basic employee request
 * 
 * GET :- To retrieve all the employees as List
 * POST:- To create new employee resource
 * DELETE : - To delete the existing employee resource
 * PUT:- To update the employee if exists or insert if no employee object found DB
 * 
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmpCrudActionController {

	@Autowired
	public EmployeeService empService;

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {

		return empService.getAllEmployee();

	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {

		return empService.getEmployeeById(id);

	}

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		return empService.saveEmployee(employee);

	}

	@PutMapping("/employee")
	public String saveOrUpdateEmployee(@RequestBody Employee employee) {
		
		return empService.saveOrUpdateEmployee(employee);

	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		
		return empService.deleteEmployeeById(id);
	}

}
