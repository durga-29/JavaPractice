package com.example.JavaPractice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DailyCode {

	public static void main(String[] args) {
//      1️. Find the First Non-Repeated Character in a String
//java 8 stream and grouping by
		String s = "My name is";
		Optional<Character> result = s.chars().mapToObj(c -> (char) c).filter(ch -> s.indexOf(ch) == s.lastIndexOf(ch))
				.findFirst();
		result.ifPresent(System.out::println);
//		case sensitive 
		String s1 = "My name is";
		String s2 = "My name is".toLowerCase(); // use this for case insensitive
		char c1 = s1.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() == 1).findFirst().get().getKey();
		System.out.println("First Non-Repeated Character in a String: " + c1);

//  2️. Find Immediate Lower and Higher Value from List for given number 
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
// find for 8
		Map<Boolean, List<Integer>> map2 = Arrays.stream(arr).boxed() // converts IntStream to Stream<Integer>
				.filter(i -> i != 8) // removes 8 from the stream
				.collect(Collectors.partitioningBy(i -> i > 8)); // splits into 2 streams as false = num <=8 ans true=
																	// num >8
//		  false = [1,2,3,4,5,6,7],
//		  true  = [9,10]	
		// sort both partitions------if array is not already sorted.
//		map2.get(false).sort(Integer::compareTo);
//		map2.get(true).sort(Integer::compareTo);	
		System.out
				.println("Immediate Lower value of 8 from stream : " + map2.get(false).get(map2.get(false).size() - 1));
		System.out.println("Immediate Higher value of 8 from stream : " + map2.get(true).get(0));

		// 2. aNother approach
		int target = 8;
		OptionalInt higher = Arrays.stream(arr).filter(i -> i > target).min();
		OptionalInt lower = Arrays.stream(arr).filter(i -> i < target).max();

		if (higher.isPresent()) {
			System.out.println("higher val : " + higher.getAsInt());
		} else {
			System.out.println("no higher value present");
		}

		if (lower.isPresent()) {
			System.out.println("Lower : " + lower.getAsInt());
		} else {
			System.out.println("no lower value present");
		}

//  3️. Find Frequency of Repeated Numbers in a List
		int arr3[] = { 1, 2, 3, 4, 5, 6, 8, 9, 98, 7, 8, 0, 10, 10 };
		Map<Integer, Long> map3 = Arrays.stream(arr3).boxed()
				.collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("Repeated numbers: " + map3);

//  4️. Find Strings Containing Character 'K'
		String str4[] = { "Kartik", "Singh", "KarGar", "Rakesh" };
		List<String> list4 = Arrays.stream(str4).filter(i -> i.contains("K")).toList();
		System.out.println("Strings Containing Character 'K': " + list4);

//  5️. Convert List of Strings to Uppercase
		List<String> list5 = Arrays.stream(str4).map(String::toUpperCase).toList();
		System.out.println("To uppercase: " + list5);

//6️. Find Maximum Repeated Number
		int[] arr6 = { 1, 2, 3, 5, 6, 98, 6, 7, 9, 9, 98, 98 };
		int a6 = Arrays.stream(arr6).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet()
				.stream().max(Comparator.comparing(i -> i.getValue())).get().getKey();
		System.out.println("Maximum Repeated Number: " + a6);

//7️. Reverse a String Word by Word
		String str7 = "My name is";
		List<String> strarr7 = Arrays.asList(str7.split(" "));
		Collections.reverse(strarr7); // [is, name, My]
		String.join(" ", strarr7); // is name My
		System.out.println(strarr7);

		String s7 = strarr7.stream().collect(Collectors.joining(""));
		System.out.println("Reverse a String Word by Word: " + s7);

//8️. Get First 3 and Last 3 Numbers from List
		int[] arr8 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println("First 3 Numbers from List: " + Arrays.stream(arr8).boxed().limit(3).toList());
		System.out.println("Last 3 Numbers from List: " + Arrays.stream(arr8).boxed().skip(arr8.length - 3).toList());

//9️. Find Count of Duplicate Characters in String
		String s9 = "kartik";
		Map<Character, Long> map9 = s9.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("Count of Duplicate Characters in String: " + map9);

//10. Find Numbers Starting with 2
		int[] arr10 = { 1, 22, 20, 25, 30, 35 };
		List<Integer> list10 = Arrays.stream(arr10).boxed().filter(i -> i.toString().startsWith("2")).toList();
		System.out.println("Numbers Starting with 2: " + list10);

// 11️. Find Missing Element from Sequence
		int[] arr11 = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
		Set<Integer> set11 = Arrays.stream(arr11).boxed().collect(Collectors.toSet());
		int a11 = IntStream.rangeClosed(1, arr11.length).boxed().filter(i -> !set11.contains(i)).findFirst().get();
		System.out.println("Missing Element from Sequence: " + a11);

// 12️. Count Strings Starting with Same Character
		String str12[] = { "Kartik", "KarSingh", "Gaurav" };
		Map<Character, List<String>> map12 = Arrays.stream(str12).collect(Collectors.groupingBy(i -> i.charAt(0)));
		System.out.println(map12);

//  13️. Find Palindrome Strings from List
		String[] str13 = { "level", "beeb", "kartik" };
		List<String> pallin = Arrays.stream(str13).filter(i -> i.contentEquals(new StringBuilder(i).reverse()))
				.toList();
		System.out.println(pallin);

//	14️. Sort Strings by their Length	
		String[] str14 = { "Kartik", "Gaurav", "Ram", "KarSingh" };
		List<String> sortedString = Arrays.stream(str14).sorted(Comparator.comparing(String::length)).toList();
		System.out.println(sortedString);

//  15️. Find Second Highest Number		
		int[] arr15 = { 5, 9, 11, 2, 8 };
		int secHigh = Arrays.stream(arr15).boxed().sorted(Comparator.comparing(Integer::intValue).reversed()).skip(1)
				.findFirst().get();
		System.out.println(secHigh);

//  16️. Group Anagrams
		String[] str16 = { "cat", "act", "tea", "eat" };
		Map<String, List<String>> map16 = Arrays.stream(str16).collect(Collectors.groupingBy(i -> {
			char[] c = i.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}));
		System.out.println(map16);
//  23️. Check if Two Strings are Anagrams
		String st1 = "Listen";
		String st2 = "siLent";
		char[] arr1 = st1.toLowerCase().toCharArray();
		char[] arr2 = st2.toLowerCase().toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(Arrays.equals(arr1, arr2));

//  17️. Convert String to Toggle Case   AnKusH -> aNkUSh
		String ans18 = "AnKusH".chars().mapToObj(
				i -> Character.isUpperCase(i) ? Character.toLowerCase((char) i) : Character.toUpperCase((char) i))
				.map(String::valueOf).collect(Collectors.joining(""));
		System.out.println(ans18);
// OR
		String input = "AnKusH";
		String str = IntStream.range(0, input.length()).mapToObj(i -> {
			char c = input.charAt(i);
			return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
		}).map(String::valueOf).collect(Collectors.joining());
		System.out.println(str);

//  18️. Count Repeated Words in String
		String s18 = "My name is is";
		Map<String, Long> map18 = Arrays.stream(s18.split(" "))
				.collect(Collectors.groupingBy(i -> i, Collectors.counting()));
		System.out.println(map18);

//   19️. If Number Divisible by 3 Then Square It
		int[] arr19 = { 2, 4, 6, 8, 2, 10, 4, 12, 6 };
		List<Integer> list19 = Arrays.stream(arr19).boxed().map(i -> i % 3 == 0 ? i * i : i).toList();
		System.out.println(list19);

//   20. Find Common Even Elements Between Two Lists   
		List<Integer> listA = List.of(1, 2, 11, 3, 25, 54, 5, 6, 7, 8);
		List<Integer> listB = List.of(3, 4, 5, 6, 9, 1, 54, 2, 25);
		Map<String, List<Integer>> map20 = listA.stream().filter(listB::contains)
				.collect(Collectors.groupingBy(i -> i % 2 == 0 ? "EVEN" : "ODD"));
		System.out.println(map20);
//   21️. Check if String is Valid Rotation
		String s21 = "abcd";
		String temp = s21 + s21;
		System.out.println(s21.contains("bcda"));
		System.out.println(s21.contains("bdca"));

//   22️. Subtract Sum of Divisible-by-6 from Non-Divisible-by-6 Numbers (1 to 30)
		int div = IntStream.rangeClosed(1, 30).filter(i -> i % 6 == 0).sum();
		int NonDiv = IntStream.rangeClosed(1, 30).filter(i -> i % 6 != 0).sum();
		System.out.println(NonDiv - div);

//   24️. Sort List of Strings by Last Character
		String[] s24 = { "Ankush", "kartik", "kunal", "banana", "apple" };
		List<String> list24 = Arrays.stream(s24).sorted(Comparator.comparing(i -> i.charAt(i.length() - 1))).toList();
		System.out.println(list24);

//   25️. Remove Duplicate Characters and Keep Order
		String s25 = "Ankush Rajendra Bhalage";
		Set<Character> set25 = new LinkedHashSet<>();
		StringBuilder sb25 = new StringBuilder();
		for (char c : s25.toCharArray()) {
			if (!set25.contains(c) && c != ' ') {
				sb25.append(c);
				set25.add(c);
			}
		}
		System.out.println(sb25.toString());
//   26.️ find out prime numbers from a list
		int[] arr27 = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13 };
		List<Integer> list27 = Arrays.stream(arr27).boxed().filter(i -> {
			if (i <= 1)
				return true;
			return IntStream.rangeClosed(2, (int) Math.sqrt(i)).allMatch(j -> i % j != 0);
		}).toList();
		System.out.println(list27);

//    28️. count list of vowels in each string from list
		Map<String, Long> map28 = Arrays.stream(s24).collect(Collectors.toMap(i -> i,
				j -> j.chars().mapToObj(k -> (char) k).filter(l -> "aeiou".indexOf(l) != -1).count()));
		System.out.println(map28);

	}



}
