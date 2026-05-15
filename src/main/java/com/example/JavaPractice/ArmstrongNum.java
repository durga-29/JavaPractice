package com.example.JavaPractice;

import java.util.stream.IntStream;

public class ArmstrongNum {

	public static void main(String[] args) {
//1.
		int num = 153;
		   boolean isArmstrong = armStrong(num);
	        System.out.println(num + (isArmstrong ? " is Armstrong" : " is NOT Armstrong"));
//2.
		IntStream.rangeClosed(100, 999)
        .filter(ArmstrongNum::isArmstrong)
        .forEach(System.out::println);

	}
	public static int power(int rem, int x) {
		int result = 1;
		for (int i = 0; i < x; i++) {
			result *= rem;
		}
		return result;
	}

	public static int countNum(int num) {
		int c = 0;
		while (num != 0) {
			c++;
			num = num / 10;
		}
		return c;
	}

	public static boolean armStrong(int num) {
		int x = countNum(num);
		int temp = num;

		int sum = 0;
		while (temp != 0) {
			int rem = temp % 10;
			sum += power(rem, x);
			temp = temp / 10;
		}
		return sum == num;
	}
	 public static boolean isArmstrong(int num) {
	        int digits = String.valueOf(num).length();
	        int sum = String.valueOf(num)
	                        .chars() // stream of char digits
	                        .map(c -> Character.getNumericValue(c)) // convert char to int
	                        .map(d -> (int) Math.pow(d, digits)) // raise to power
	                        .sum();
	        return sum == num;
	    }
}
