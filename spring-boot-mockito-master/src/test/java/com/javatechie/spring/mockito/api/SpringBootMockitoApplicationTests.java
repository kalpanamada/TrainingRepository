package com.javatechie.spring.mockito.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.spring.mockito.api.dao.UserRepository;
import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	public void getUsersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new User(376, "Danile", 31, "USA"), new User(958, "Huy", 35, "UK"), new User(954, "Bala", 35, "UK"))
				.collect(Collectors.toList()));
		assertEquals(3, service.getUsers().size());
	}

	@Test
	public void getUserbyAddressTest() {
		String address = "Bangalore";
		when(repository.findByAddress(address))
				.thenReturn(Stream.of(new User(376, "Danile", 31, "USA")).collect(Collectors.toList()));
		assertEquals(1, service.getUserbyAddress(address).size());
	}

	@Test
	public void addUserTest() {

		User userObj = new User(999, "Pranya", 33, "Pune");
		when(repository.save(userObj)).thenReturn(userObj);
		assertEquals(userObj, service.addUser(userObj));
	}

	@Test
	public void deleteUserTest() {
		User user = new User(999, "Pranya", 33, "Pune");
		service.deleteUser(user);
		verify(repository, times(1)).delete(user);
	}

}
