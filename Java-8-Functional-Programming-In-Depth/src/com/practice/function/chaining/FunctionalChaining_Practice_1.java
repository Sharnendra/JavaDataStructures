package com.practice.function.chaining;

public class FunctionalChaining_Practice_1 {
	
	public static void main(String[] args) {
		Function<String,Integer> getLenght =(s)->s.length();
		
		
		
		Function<Integer, String> createList =(i)->{
			String s="";
			int j=96;
			for(int k=0;k<=i-1;k++) {
				j++;
				s=s+String.valueOf((char)j)+" ";
				}
			return s;
		};
				
		Function<String,Integer> de=getLenght.andThen(createList).andThen(getLenght);
		
		//String av=de.convert("Soumen");
		//System.err.println(av.size());
		//av.stream().forEach(System.out::println);
		System.out.println(de.convert("Soumen"));
	}
}


@FunctionalInterface
interface Function<T,R>{
	R convert(T t); /// t - sTRING   , R-- INTEGER

	default <V> Function<T,V> andThen(Function<R, V> next) {
		return (T t)->{
			V v=next.convert(this.convert(t));
			return v;
		};
	}
	
	default <K> Function<T, K> afterThen(Function<R, K> next){
		return null;
	}
}