package com.example.demo.repository;



import com.example.demo.model.Employee;

public interface CustomRepo {
	
	
	Employee getEmployee(String name);
	Employee saveEmplyee(Employee emplyoee);

}
