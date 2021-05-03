package com.practice.function.java8.programming;

import java.util.function.UnaryOperator;

public class FactorialJavaLamda {
	static final UnaryOperator<Double> FACTORIAL = x -> x  == 1
		      ? 1
		      : x * FactorialJavaLamda.FACTORIAL.apply(x - 1);

	public static void main(String[] args) {
		System.out.println(FACTORIAL.apply(18.00));
	}

}
