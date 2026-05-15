package com.example.JavaPractice;

public class Palindrome {

	public static void main(String[] args) {
		String str = "Racecar";
		String reverse ="";
		  for(int i=str.length()-1;i>=0;i--){
	            reverse=reverse+str.charAt(i);
	        }
	        System.out.println(reverse);
	        if(str.equals(reverse)){
	            System.out.println("String is palindrome");
	        }else {
	            System.out.println("Not Palindrome");
	        }
	}

//	String str = "";
//	int left=0,  right=str.length()-1;
//	while(left<right) {
//		if(str.charAt(left) != str.charAt(right)) {
//			return false;
//		}
//		left++;
//		right--;
//	}
//	return true;
	
}
