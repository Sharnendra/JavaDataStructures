package com.practice.function.java8.programming;

import java.util.Arrays;

public class FindPairWithMinimumSum {

	public static void main(String[] args) {

		int array[] = {1, 30, -5, 70, -8, 20, -40, 60};
		int pairs[] = getPairClosestToZero(array);
		System.out.println(pairs[0]+" "+pairs[1]);
	}
	
	public static int[] getPairClosestToZero(int[] data) {
		if(data.length<0) return null;
		Arrays.sort(data);
		int sum = 0, l = 0, r=data.length-1;
		int minSum = Integer.MAX_VALUE;
		int minLeft=l, minRight=r;
		
		while(l<r) {
			sum = data[l]+ data[r];
			if(Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = l;
				minRight = r;
			}
			if(sum<0) l++;
			else r--;
		}
		int[] pair = {data[minLeft], data[minRight]};
		return pair;
	}
}
