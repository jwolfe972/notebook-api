package com.jordanbook.notebook;

import com.jordanbook.notebook.models.User;
import com.jordanbook.notebook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NotebookApplication implements CommandLineRunner {


	private final UserService userService;


	@Autowired
	public NotebookApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(NotebookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User jordan = new User("jwolfe972", "Jordn", "Wolfe", "salt", "pass", "jwolfe972@gmail.com");

		userService.AddUser(jordan);


		List<User> uList = userService.ListAllUsers();


		for(User u : uList){


			System.out.println(u);
		}


		jordan.setFirstName("Random");

		userService.UpdateUser(jordan);


		 uList = userService.ListAllUsers();




		for(User u : uList){


			System.out.println(u);
		}



















	}
}
