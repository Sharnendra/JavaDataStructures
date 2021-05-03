package com.test.practice;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8CollectionStream {

	public static void main(String[] args) {
		
				Map<Integer, Map<String, List<String>>> temp =Resource.getComplexMap();
				
				List<String> t= temp.entrySet().stream()          //Streaming from 1st Level of Map
				.filter(x->x.getKey()!=3)                         //Filtering Data on key value of 1st level of map
				.flatMap(x-> x.getValue().entrySet().stream())    //Retrieving filtered 2nd level of map 
				.filter(x->x.getKey()!="A1")					  //Filtering data on 2nd Level
				.flatMap(x->x.getValue().stream())				  //Retrieving filtered list in form of stream
				.collect(Collectors.toList());
				
				t.stream().forEach(x->System.out.println(x));
	}
	
	public static Function<String, Integer> s2 =(String s)->{
		return Integer.valueOf(s);
	};
	public static Function<String, Integer> s1 =(String s)->{
		return s2.apply(s);
	};
	
	
}
