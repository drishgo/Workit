package com.Workit.Workit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class WorkitApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkitApplication.class, args);
	}

}
