package com.example.EmailApplication;

import com.example.EmailApplication.Services.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

	@Autowired
	EmailService emailService;

	@Test
	public void shouldCreateEmail(){
		Assertions.assertNotNull(emailService.createEmail("Test"));
	}

	@Test
	public void shouldGetAllValues(){
		Assertions.assertNotNull(emailService.viewAllEmail());
	}

}
