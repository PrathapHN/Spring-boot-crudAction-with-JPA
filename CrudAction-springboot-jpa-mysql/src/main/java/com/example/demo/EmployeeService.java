package com.example.demo;

/**
 * 
 * @author prathapa
 * 
 * 
 * EmployeeService :- Acts as service layer 
 * 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeRepository empRepository;

	public List<Employee> getAllEmployee() {

		return (List<Employee>) empRepository.findAll();

	}

	public Employee getEmployeeById(int id) {
		
		Optional<Employee> opt = empRepository.findById(id);
		
		return opt.get();
	}

	public Employee saveEmployee(Employee employee) {
		
		return empRepository.save(employee);

	}

	public String saveOrUpdateEmployee(Employee employee) {
		 		
		Optional<Integer> empIdcheck = Optional.ofNullable(employee.getID());

		if (empIdcheck.isPresent()) {

			Optional<Employee> employee1 = empRepository.findById(employee.getID());
			
			employee1.ifPresentOrElse((employee2) -> {
				
				System.out.println(" Inside update ");
				employee2.setFirstName(employee.getFirstName());
				employee2.setSecondName(employee.getSecondName());
				employee2.setAddress(employee.getAddress());
				empRepository.save(employee2);

			}, () -> {
				System.out.println(" Inside insert ");
				
				empRepository.save(employee);

			});

		}

		return "Insertion/updation is done";

	}

	public String deleteEmployeeById(int id) {
		
		 empRepository.deleteById(id);
		
		return "Deleted Succesfully";

	}

}
