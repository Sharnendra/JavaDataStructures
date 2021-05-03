package com.test.practice;
@FunctionalInterface
public interface FunctionalTestInterface {

	public int show(int a, int b);
	
	default public int shown(int a, int b) {
		return a*b;
	}
	default public String shown2(String a, String b) {
		return a+" "+b;
	}
	
	static public void showHi() {
		System.out.println();
	}
}
