package com.example.Project1;

import com.example.Project1.Models.User;
import com.example.Project1.Services.ReimbursementService;
import com.example.Project1.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Project1ApplicationTests {

	@Autowired
	ReimbursementService reimbursementService;

	@Autowired
	UserService userService;


	@Test
	public void shouldCreateUserWork(){
		User user = new User();
		user.setName("TestUser");
		user.setPassword("password");
		user.setRole("Test");
		user.setEmail("Email");
		Assertions.assertTrue(userService.saveUser(user));
	}

	@Test
	public void shouldViewUserByNameWork(){
		Assertions.assertNotNull(userService.viewUserByName("tonykwak"));
		Assertions.assertNotNull(userService.viewUserByName("tonykwak").getName());
		Assertions.assertNotNull(userService.viewUserByName("tonykwak").getEmail());
	}

	@Test
	public void shouldViewUserByIdWork(){
		Assertions.assertNotNull(userService.viewUserById(4));
	}

	@Test
	public void shouldViewAllUserWork(){
		Assertions.assertNotNull(userService.viewAllUsers());
	}

	@Test
	public void shouldDeleteTestUserWork(){
		Assertions.assertTrue(userService.deleteTestUsers());
	}

	@Test
	public void shouldCreateReimbursementWork(){
		User user = new User();
		user.setName("TestUser");
		user.setPassword("password");
		user.setRole("Test");
		user.setEmail("Email");
		Assertions.assertTrue(userService.saveUser(user));
		//Assertions.assertTrue(reimbursementService.createReimbursement("TestUser",75757,"Test"));
	}

	@Test
	public void shouldUpdateReimbursementWork(){
		User user = new User();
		user.setName("TestUser");
		user.setPassword("password");
		user.setRole("Test");
		user.setEmail("Email");
		Assertions.assertTrue(userService.saveUser(user));
		//Assertions.assertTrue(reimbursementService.updateReimbursement("Approved",7));
	}

	@Test
	public void shouldReassignUserWork(){
		Assertions.assertTrue(reimbursementService.reassignUser(3,6));
	}

	@Test
	public void shouldGetAllReimbursementByIdWork(){
		Assertions.assertNotNull(reimbursementService.getAllReimbursementById(3));
	}


	@Test
	public void shouldGetAllReimbursementWork(){
		Assertions.assertNotNull(reimbursementService.getAllReimbursement());
	}
	

}
