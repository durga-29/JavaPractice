package com.example.JavaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class DailyType {

	public long factorial(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public void pallindrome() {
		String s = "Racecar";
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse = reverse + s.charAt(i);
		}
		if (s.equals(reverse)) {
			System.out.println("pallin");
		} else {
			System.out.println("not");
		}
	}

	public boolean pallindromeTwoPoiter() {
		String str = "Racecar";
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public void binarySearch() {
		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		int left = 0;
		int right = arr.length - 1;
		int target = 13;

		while (left < right) {
			int mid = (left + right) / 2;
			if (target == arr[mid]) {
				System.out.println(mid);
				break;
			}
			if (target < arr[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}
	}

	public void findLowHigh() {
		int[] arr = { 2, 3, 1, 6, 33, 45, 9, 4, 8, 7, 5 };
		int target = 5;
		OptionalInt higher = Arrays.stream(arr).filter(i -> i > target).min();
		OptionalInt lower = Arrays.stream(arr).filter(i -> i < target).max();

		if (higher.isPresent()) {
			System.out.println("higher : " + higher.getAsInt());
		} else {
			System.out.println("No higher value present");
		}
		if (lower.isPresent()) {
			System.out.println("lower : " + lower.getAsInt());
		} else {
			System.out.println("No lower value present");
		}
	}
	
	public void findStringContainingChar() {
		String str4[] = { "Kartik", "Singh", "KarGar", "Rakesh" };
		List<String> list = Arrays.stream(str4).filter(i->i.contains("K")).toList();
		System.out.println("Strings Containing Character 'K': " + list);
	}

	public void convertToUppercase() {
		String str4[] = { "Kartik", "Singh", "KarGar", "Rakesh" };
		List<String> list = Arrays.stream(str4).map(String::toUpperCase).toList();
		System.out.println("Uppercase : "+list);
	}
	
	public void firstAndLastThree() {
	int [] arr8={1,2,3,4,5,6,7,8,9,10};
	System.out.println(Arrays.stream(arr8).boxed().limit(3).toList());
	System.out.println(Arrays.stream(arr8).boxed().skip(arr8.length-3).toList()
			);
	}
	
}
