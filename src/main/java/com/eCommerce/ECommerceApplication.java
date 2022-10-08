package com.eCommerce;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eCommerce.domain.User;
import com.eCommerce.domain.security.Role;
import com.eCommerce.domain.security.UserRole;
import com.eCommerce.service.UserService;
import com.eCommerce.utility.SecurityUtility;


@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//
			User user11 = new User();
			user11.setUsername("user");
			user11.setPassword(SecurityUtility.passwordEncoder().encode("user"));
			user11.setEmail("user@gmail.com");
			Set<UserRole> userRoles = new HashSet<>();
			Role role2= new Role();
			role2.setRoleId(1);
			role2.setName("ROLE_USER");
			userRoles.add(new UserRole(user11, role2));

			userService.createUser(user11, userRoles);
		}



}

