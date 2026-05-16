package com.example.JavaPractice.java;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streaming {

	public static void main(String[] args) {
		// Find the first Non-Repeated Character in given String
		String string1 = "My nam is";
		string1.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(i -> i.getValue() == 1).findFirst().get().getKey();

		// Find the Immediate lowest and highest value
		List<Integer> lst1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int num = 8;
		Map<Boolean, List<Integer>> map2 = lst1.stream().filter(i -> i != num)
				.collect(Collectors.partitioningBy(i -> i > num));
		Integer high = map2.get(true).get(0);
		Integer low = map2.get(false).get(map2.get(false).size() - 1);

		// Find the frequency/or count how many Number are repeated
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 9, 98, 7, 8, 0, 10, 10);
		list2.stream().collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream().filter(i -> i.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
				.forEach((k, v) -> System.out.println(k + " repeated: " + v));

		// Find the String which contains 'k'
		List<String> list3 = Arrays.asList("Kartik", "Singh", "KarGar");
		list3.stream().filter(i -> i.toLowerCase().contains("k")).forEach(System.out::println);
//		list3.stream().filter(i -> i.indexOf('K') != -1).forEach(System.out::println);    
//		list3.stream().filter(i -> i.matches(".*(?i)k.*")).forEach(System.out::println);   // regex

	}
}
