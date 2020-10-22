package com.example.demo.repository.impl;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.repository.CustomRepo;



@Repository
public class CustomRepoImpl implements CustomRepo{
	@Autowired
	MongoTemplate mongotemplate;

	public Employee getEmployee(String name) {
		Query query=new Query();
		query.addCriteria(Criteria.where("firstName").is(name));
		
		Employee emp =mongotemplate.findOne(query, Employee.class);
		return emp;
	}

	@Override
	public Employee saveEmplyee(Employee emplyoee) {
		return mongotemplate.insert(emplyoee);
	}


}
