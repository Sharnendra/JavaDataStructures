package com.test.practice;

import java.time.LocalTime;
import java.util.function.Function;

public class ReverseString {
	
	public static void main(String[] args) {
		System.out.println(LocalTime.now());
		System.out.println(reverseCompleteWithSpaceString.apply("Sandeep is a good boy"));
		System.out.println(LocalTime.now());
	}
	
	@SuppressWarnings("unused")
	private static Function<String, String> reverseCompleteString =(String a)->{
		char arr[]=a.toCharArray();
		a=a+":";
		for(int i=arr.length-1;i>=0; i--) {
			a=a+arr[i];
		}
		return a.split(":")[1];
	};
	
	private static Function<String, String> reverseCompleteWithSpaceString =(String a)->{
		String arr[] =a.split(" ");
		a=a+":";
		for(int i=0;i<=arr.length-1;i++)
		{
			if(arr[i].length()%2==0) {
				a=a+arr[i]+" ";
			}
			else {
				char[] x=arr[i].toCharArray();
				for(int j=x.length-1;j>=0; j--) {
					a=a+x[j];
				}
				a=a+" ";
			}
		}
		System.out.println(a);
		return a.split(":")[1].trim();
	};

}
