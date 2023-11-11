package com.example.EventManagementSystem;

import com.example.EventManagementSystem.domain.Admin;
import com.example.EventManagementSystem.domain.SecuredUser;
import com.example.EventManagementSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private AdminService adminService;
	public static void main(String[] args) {
		SpringApplication.run(EventManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = Admin.builder()
				.name("admin1")
				.email("admin1@gmail.com")
				.securedUser(SecuredUser.builder()
						.username("admin1")
						.password("admin1@123")
						.build())
				.build();
		adminService.createAdmin(admin);

	}
}
