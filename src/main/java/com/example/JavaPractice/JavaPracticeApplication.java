package com.example.JavaPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPracticeApplication {

	

    public static void main(String[] args) {
		SpringApplication.run(JavaPracticeApplication.class, args);

		Factorial f = new Factorial();
    	long fact =f.factorial(4);
        System.out.println("Factorial " + fact);

        
        
	}

}
