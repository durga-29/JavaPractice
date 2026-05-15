package com.example.JavaPractice;

public class Factorial {

	public  long factorial(int n) {
		if(n<0) {
			throw new IllegalArgumentException();
		}
		if(n==0 || n==1) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
}
