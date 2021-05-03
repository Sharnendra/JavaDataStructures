package com.practice.function.java8.streamsPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapBasedStreamManipulation {

	public static void main(String[] args) {
		Map<Integer, Map<String, List<String>>> data=new HashMap<>();
		
		
		Map<String, List<String>> map1= new HashMap<>();
		List<String> b1=Arrays.asList("Data1","Data2","Data3");
		map1.put("Sharnendra", b1);
		data.put(1, map1);
		
		Map<String, List<String>> map2= new HashMap<>();
		List<String> b2=Arrays.asList("Data3","Data4","Data5");
		map2.put("Shailesh", b2);
		data.put(2, map2);
		
		Map<String, List<String>> map3= new HashMap<>();
		List<String> b3=Arrays.asList("Data5","Data6","Data7");
		map3.put("Sourav", b3);
		
		
		List<String> b4=Arrays.asList("Data7","Data8","Data9");
		map3.put("Sachin", b4);
		data.put(3, map3);
		
		System.out.println(data);
		
		List<String> collection = data.entrySet().stream()
		.flatMap(x->x.getValue().entrySet().stream())
		.filter(x->x.getKey()!="Sachin")
		.flatMap(x->x.getValue().stream())
		.distinct()
		.collect(Collectors.toList());
		
		/*
		 * List<Collection<List<String>>> collection = data.entrySet().stream()
		 * .map(x->x.getValue()) .map(x->x.values()) .distinct()
		 * .collect(Collectors.toList());
		 */
		List<String> collect = data.entrySet().stream()
		.map(x->x.getValue().entrySet())
		.flatMap(x->x.stream()).map(x-> x.getValue()).flatMap(x->x.stream()).distinct().collect(Collectors.toList());
		System.out.println(collection);
		System.out.println(collect);
	}

}
