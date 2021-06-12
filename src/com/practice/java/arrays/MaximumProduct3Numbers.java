package com.practice.java.arrays;

public class MaximumProduct3Numbers {
	
	public int findMaxProduct(int[] array) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		for (int i=0; i<array.length; i++) {
			if(array[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = array[i];
			} else if(array[i] > max2) {
				max3 = max2;
				max2 = array[i];
			} else if(array[i] > max3) {
				max3 = array[i];
			} 
			if(array[i] < min1) {
				min2 = min1;
				min1 = array[i];
			} else if(array[i] < min2) {
				min2 = array[i];
			}
		}
		System.out.println(String.format("max1 %d, max2 %d, max3 %d, min1 %d, min2 %d",  max1, max2, max3, min1, min2));
		return Math.max(min1*min2*max1, max1*max2*max3);
	}
	
	public static void main(String[] args) {
		MaximumProduct3Numbers maximumProduct3Numbers = new MaximumProduct3Numbers();
		System.out.println(maximumProduct3Numbers.findMaxProduct(new int[]{1,2,5,9,3,2,10}));
		System.out.println(maximumProduct3Numbers.findMaxProduct(new int[]{-10,2,5,-20,3,2,10}));
		System.out.println(maximumProduct3Numbers.findMaxProduct(new int[]{-10,2,-5,-20,3,2,10}));
	}
}
