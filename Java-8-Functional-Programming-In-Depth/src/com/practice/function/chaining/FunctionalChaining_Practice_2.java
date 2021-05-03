package com.practice.function.chaining;

import java.util.Objects;

public class FunctionalChaining_Practice_2 {

	public static void main(String[] args) {
		Consumer<String> d1=(s)->s.length();
		Consumer<String> d2=(s)->{
			for(int i=0;i<s.length();i++) {System.out.println(s.charAt(i));}
		};
		
		Consumer<String> d3=d1.andThen(d2);
		d3.accept("Sharnendradey");

	}

}

@FunctionalInterface
interface Consumer<T> {
	void accept(T t);

	default Consumer<T> andThen(Consumer<T> next){
		Objects.requireNonNull(next);
		return (T t)->{
			this.accept(t);
			next.accept(t);
		};
	}
}