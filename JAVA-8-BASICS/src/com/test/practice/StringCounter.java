package com.test.practice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringCounter {
	public static Map<Character,Integer> data =new HashMap<Character,Integer>();;

	public static void main(String[] args) {
		System.err.println(LocalTime.now());
		String s="Hi My Name is Sharnendra Dey";
		Map<Character,Integer> data = getCharacterCount.apply(s);
		data.entrySet().stream().forEach(x->{
			System.out.println(x.getKey()+" "+x.getValue());
		});
		System.err.println(LocalTime.now());
		
		
		System.out.println(LocalTime.now());
		FunctionalTestInterface av =(a,b)->a*b;
		
		System.out.println(av.show(10,20));
		
av =(a,b)->a-b;
		
		System.out.println(av.show(10,20));
		
av =(a,b)->b/a;
		
		System.out.println(av.show(10,20));
av =(a,b)->a+b;
		
		System.out.println(av.show(10,20));
		System.out.println(LocalTime.now());
		
		
		
		
		
		
	}
	
	private static Predicate<Character> testSpace = (Character t)->{
		return t==' '?false:true;
	};
	
	private static Consumer<Character> consumeData = (Character elements)->{
		if(!data.containsKey(elements)) {
			data.put(elements, 1);
		}else {
			data.put(elements, data.get(elements)+1);
		}
	};
	
	private static Function<String, Map<Character,Integer>> getCharacterCount =(String a)->{
		List<Character> characterList=a.chars().mapToObj(x -> (char)x).filter(z->testSpace.test(z)).collect(Collectors.toList());
		characterList.stream().forEach(x->consumeData.accept(x));
		return data;
	};

}
