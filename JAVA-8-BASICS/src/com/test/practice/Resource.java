package com.test.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Resource {

	public static Map<Integer, Map<String, List<String>>> getComplexMap(){
		List<String> d1=new ArrayList<>();
		List<String> d2=new ArrayList<>();
		List<String> d3=new ArrayList<>();
		List<String> d4=new ArrayList<>();
		
		List<String> d5=new ArrayList<>();
		List<String> d6=new ArrayList<>();
		List<String> d7=new ArrayList<>();
		List<String> d8=new ArrayList<>();
		
		d1.add("AB");
		d1.add("BC");
		
		d2.add("CD");
		d2.add("DE");
		
		d3.add("EF");
		d3.add("FG");
		
		d4.add("AB1");
		d4.add("BC2");
		
		d5.add("CD3");
		d5.add("DE4");
		
		d6.add("EF5");
		d6.add("FG6");
		
		d7.add("ABx");
		d7.add("BCx");
		
		d8.add("CDx");
		d8.add("DEx");
		
		 Map<String, List<String>> t1=new LinkedHashMap<>();
		 Map<String, List<String>> t2=new LinkedHashMap<>();
		 Map<String, List<String>> t3=new LinkedHashMap<>();
		 
		 t1.put("A", d1);
		 t1.put("B", d2);
		 t1.put("C", d3);
		 
		 t2.put("A1", d4);
		 t2.put("B1", d5);
		 
		 t3.put("Ax", d6);
		 t3.put("Ax", d7);
		 t3.put("Ax", d8);
		 
		 Map<Integer, Map<String, List<String>>> temp =new LinkedHashMap<>();
		 temp.put(1, t1);
		 temp.put(2, t2);
		 temp.put(3, t3);
		
		return temp;
	}
}
