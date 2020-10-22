package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.impl.CustomRepoImpl;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController{
	
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 
	 @Autowired
	 private CustomRepoImpl customRepoImpl;
	
	@PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
       // employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
		//employee.setId(1);
       // return employeeRepository.save(employee);  
		return customRepoImpl.saveEmplyee(employee);
        
    }
	
	 @GetMapping("/employees/{id}")
	    public ResponseEntity < Employee > getEmployeeById(@PathVariable(value = "id") Long employeeId)	   {
		/* Employee employee = employeeRepository.findById(employeeId).get(); */
		 Employee employee = customRepoImpl.getEmployee("Bala");
	        System.out.println(employee.toString());
	        return ResponseEntity.ok().body(employee);
	    }
	 
	 @PutMapping("/employees/{id}")
	    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
	         @RequestBody Employee employeeDetails){
	        Employee employee = employeeRepository.findById(employeeId).get();
	        employee.setEmailId(employeeDetails.getEmailId());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setFirstName(employeeDetails.getFirstName());
	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	        
	    }
	 
	 @DeleteMapping("/employees/{id}")
	    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
	     {
	        Employee employee = employeeRepository.findById(employeeId).get(); 
	        employeeRepository.delete(employee);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
