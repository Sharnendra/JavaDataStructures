package com.oracle.data.bean;

public class EmployeeRender {

	public static void main(String[] args) {
       //List<Employee> db = Employee.getEmployeeList();
       A a = new B();
		a.f(10);
	}

}

class A {
	public void f(Integer i){
		System.out.println("AAA");
	}
}

class B extends A{
	public void f(int i){
		System.out.println("BBBBB");
	}
}


/*
 * class EmployeeNameAgeComparator implements Comparator{
 * 
 * @Override public int compare(Object o1, Object o2) { Employee e1 =
 * (Employee)o1; Employee e2 = (Employee)o2;
 * 
 * if(e1.getAge() == e2.getAge || e1.getName().equalsIgnoreCase(e2.getName()))
 * return 0;
 * 
 * else if(e1.getAge()>e2.getAge() || e1.getName()>) }
 * 
 * }
 */
