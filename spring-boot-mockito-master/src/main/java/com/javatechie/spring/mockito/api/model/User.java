package com.javatechie.spring.mockito.api.model;

import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	private int age;
	private String address;
	
	
	public User(int id,String name,int age,String address) {
	  this.id = id;
	  this.name = name;
	  this.age = age;
	  this.address = address;
	}

}
