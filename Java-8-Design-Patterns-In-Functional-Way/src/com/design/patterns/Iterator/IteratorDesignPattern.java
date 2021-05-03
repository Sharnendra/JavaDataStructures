package com.design.patterns.Iterator;

import java.util.function.Consumer;

/*
 * Iterator Design patterns are the behavior design patterns
 * Which determines how Objects interact with each other.
 * */
public class IteratorDesignPattern {

	/*
	 * Iterator Design patterns tells us about accessing the
	 * elements of the container without exposing the structure of the object.
	 * 
	 * For example: Iterator and Enumeration.....
	 * */
	public static void main(String[] args) {

		MyArrayList list=new MyArrayList(new Object[] {1,2,23,56,4,355,2,"Data"});
		list.forEach(System.out::println);
	}

}

class MyArrayList{
	
	Object elements[] = new Object[5];
	
	public MyArrayList(Object[] elements) {
		this.elements=elements;
	}
	
	public void forEach(Consumer<Object> action) {
		for(int i=0;i<elements.length;i++) {
			action.accept(elements[i]);
		}
	}
}
